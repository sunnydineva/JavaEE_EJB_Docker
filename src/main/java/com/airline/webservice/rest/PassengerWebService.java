package com.airline.webservice.rest;

import com.airline.models.Passenger;
import com.airline.service.PassengerService;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/passengers")
public class PassengerWebService
{

    @PersistenceContext(unitName = "airline_persistence_unit")
    EntityManager em;

    @EJB
    PassengerService ps;

    @Context //specific for the JAX-RS services context
    UriInfo pUriInfo; //useful when we create a new resource on our app and we want to expose the url of the newly created flight, we want to construct url-s and use it

    public PassengerWebService()
    {
    }
    // Classes managed by JAX-RS has limited injects.
    // FlightWebService has @Path => the class becomes managed bean
    // => injections of EJB still works
    // that's why noArgsConstructor
    // <= te be managed automatically by the container, in case JAX-RS

    @GET()
    @Produces(MediaType.APPLICATION_XML) //needs Jax-B in Entity
    public List<Passenger> getPassengers()
    {
        List<Passenger> pList = ps.getPassengers();

        return pList;
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("{passenger_id}")
    public Passenger getPassenger(@PathParam("passenger_id") Integer passengerId)
    {
        Passenger p = ps.getPassenger(passengerId);

        if (p == null)
        {
            throw new NotFoundException("The passenger with an id of " + passengerId + " was not found");
        }
        return p;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPassenger(Passenger p)
    {
        p = ps.addPassenger(p); //after it's persisted, it will have an id
        UriBuilder pUriBuilder = pUriInfo.getAbsolutePathBuilder();
        URI pUri = pUriBuilder.path(String.valueOf(p.getId())).build();

        return Response.created(pUri).build();
    }

    @PUT
    @Path("/edit/{pId}") //we have to provide all the new datas, not only for change
    @Consumes("application/json")
    public Response updatePassenger(@PathParam("pId") Integer passengerId, Passenger pUpdated)
    {
        pUpdated = ps.updatePassenger(passengerId, pUpdated);

        if(pUpdated == null)
        {
            throw new NotFoundException("The passenger with id of " + passengerId + " was not found");
        }

        return Response.ok(pUpdated).build();
    }

    @PUT
    @Path("/edit2/{pId}")
    @Consumes("application/json")
    public Response updatePassenger2(@PathParam("pId") Integer passengerId, Passenger pUpdated)
    {
        pUpdated = ps.updatePassenger2(passengerId, pUpdated);

        if(pUpdated == null)
        {
            throw new NotFoundException("The passenger with id of " + passengerId + " was not found");
        }

        return Response.ok(pUpdated).build();
    }
}
