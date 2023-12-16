package com.airline.webservice.rest;

import com.airline.models.Passenger;
import com.airline.service.PassengerService;

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

@Path("/passengers")
public class PassengerWebService {

    @PersistenceContext(unitName = "airline_persistence_unit")
    EntityManager em;

    @EJB
    PassengerService ps;

    @Context //specific for the JAX-RS services context
    UriInfo fUriInfo; //useful when we create a new resource on our app and we want to expose the url of the newly created flight, we want to construct url-s and use it

    public PassengerWebService()
    {
    }
    // Classes managed by JAX-RS has limited injects.
    // FlightWebService has @Path => the class becomes managed bean
    // => injections of EJB still works
    // that's why noArgsConstructor
    // <= te be managed automatically by the container, in case JAX-RS

    @GET()
    @Produces(MediaType.APPLICATION_XML) //neesds Jax-B in Entity
    public List<Passenger> getPassengers()
    {
        List<Passenger> pList = ps.getPassengers();

        return pList;
    }
}
