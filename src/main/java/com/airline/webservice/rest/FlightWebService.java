package com.airline.webservice.rest;

import com.airline.dto.FlightMapper;
import com.airline.dto.FlightResponseDto;
import com.airline.models.Flight;
import com.airline.service.FlightService;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.stream.Collectors;

@Path("/flights")
@Transactional
public class FlightWebService {

    @PersistenceContext(unitName = "airline_persistence_unit")
    EntityManager em;

    @EJB
    FlightService fs;

    @Context //specific for the JAX-RS services context
    UriInfo fUriInfo; //useful when we create a new resource on our app and we want to expose the url of the newly created flight, we want to construct url-s and use it

    public FlightWebService() {
    }
    // Classes managed by JAX-RS has limited injects.
    // FlightWebService has @Path => the class becomes managed bean
    // => injections of EJB still works
    // that's why noArgsConstructor
    // <= te be managed automatically by the container, in case JAX-RS

    @GET()
    @Produces(MediaType.APPLICATION_JSON) //localhost:8080/ejb/airlineservices/rest/
    public List<FlightResponseDto> getFlights()
    {

        return fs.getFlights().stream()
                .map(FlightMapper::toDto)
                .collect(Collectors.toList());
    }

    @DELETE
    @Path("{flightId}")
    public Response deleteFlight(@PathParam("flightId") Integer flightId)
    {
        Flight flightToRemove = em.find(Flight.class, flightId);

        if(flightToRemove == null)
        {
            throw new NotFoundException("The flight with id of " + flightId + " was not found.");
        }

        em.remove(flightToRemove);
        //-this method has to be run with Transaction
        //no Transaction on this class, this is not EJB (like), managed by JAX-RS, not in servlet, no
        // several solutions
        //-beanManaged Transaction: various methods for start, ends of transactions, JTA API- for talk with TransactionManager
        //-@Transactional (Java EE7+) on the class or method
        //-FlightEntty class - remove the flight=> remove the pilots, associates with the flight <-Cascade

        return Response.noContent().build();
    }
}
