package com.airline.service;

import com.airline.models.Flight;
import com.airline.models.Passenger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

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

    public void addFlightTicketToPassenger(String flightId, String passengerId)
    {
        //Getting the passenger by Id
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Passenger> cqPassenger = builder.createQuery(Passenger.class);

        Root<Passenger> pRoot = cqPassenger.from(Passenger.class);

        cqPassenger.select(pRoot).where(builder.equal(pRoot.get("id").as(Integer.class), passengerId));

        //        TypedQuery<Passenger> typedQuery = em.createQuery(cqPassenger);
        //        Passenger p = typedQuery.getSingleResult();
        Passenger p = em.createQuery(cqPassenger).getSingleResult(); //short

        //Getting flight by id
        builder = em.getCriteriaBuilder();

        CriteriaQuery<Flight> cqFlight = builder.createQuery(Flight.class);

        Root<Flight> fRoot = cqFlight.from(Flight.class);

        cqFlight.select(fRoot).where(builder.equal(fRoot.get("id").as(Integer.class), flightId));

        Flight f = em.createQuery(cqFlight).getSingleResult();

        //Associate the flight with the passenger
        List<Flight> fList = p.getFlights();

        fList.add(f);

        p.setFlights(fList);

        f.getPassengers().add(p);

    }
    public List<Passenger> getPassengers()
    {
        TypedQuery query = em.createQuery("SELECT p from Passenger p", Passenger.class);
        List resultList = query.getResultList();
        return resultList;
    }

}
