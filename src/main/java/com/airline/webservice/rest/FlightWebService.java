package com.airline.webservice.rest;

import com.airline.models.Flight;
import com.airline.service.FlightService;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/flights")
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
    public List<Flight> getFlights()
    {
        List<Flight> fList = fs.getFlights();

        return fList;
    }
}
