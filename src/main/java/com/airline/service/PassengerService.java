package com.airline.service;

import com.airline.models.Passenger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean Implementation class PassengerService
 */

@Stateless
@LocalBean
public class PassengerService
{
    public PassengerService()
    {
    }

    //Inject through the Context Dependency Injection the Persistence unit that we've c
    @PersistenceContext(unitName = "airline_persistence_unit") //  from persistence.xml: <persistence-unit name="airline_persistence_unit">
    EntityManager em; //allows us to communicate with the DB

    public void addPassenger(Passenger p) //called from the addPassenger servlet
    {
        em.persist(p); //add row into the table passengers
    }

}
