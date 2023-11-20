package com.airline.service;

import com.airline.models.Airplane;
import com.airline.models.Flight;
import com.airline.models.Passenger;
import com.airline.models.Pilot;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@SuppressWarnings("ALL")
@Stateless
@LocalBean
public class FlightService
{
    public FlightService()
    {
    }
    @PersistenceContext(unitName = "airline_persistence_unit")
    EntityManager em;

    //    EntityManager em = Persistence.createEntityManagerFactory("your_persistence_unit_name").createEntityManager();

    public void addFlight(Flight f, Airplane a)
    {
        em.persist(f);
//        em.persist(a); //propagated and cascaded from flight and saved automatically
    }

    public void addPilotToFlight(String pilotId, String flightId)
    {
        TypedQuery<Flight> flightTypedQuery = em.createNamedQuery("Flight.findById", Flight.class);
        flightTypedQuery.setParameter("flightID", Integer.parseInt(flightId));

        Flight f = flightTypedQuery.getSingleResult();

        TypedQuery<Pilot> pilotTypedQuery = em.createNamedQuery("Pilot.findByIdSomeNAME", Pilot.class);
        pilotTypedQuery.setParameter("pilotID", Integer.parseInt(pilotId));

        Pilot p = pilotTypedQuery.getSingleResult();

        List<Pilot> pilotList = f.getPilots();
        pilotList.add(p);
//        f.setPilots(pilotList); //redundant

        p.setFlightForPilot(f);
    }

    public void addPassengerToFlight(String passengerId, String flightId)
    {
        //Getting the passenger by id using CriteriaQuery, not NamedQuery or TypedQuery

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

        //Associate the passeger with the flight
        List<Passenger> pList = f.getPassengers();
        pList.add(p);

        f.setPassengers(pList);

        p.getFlights().add(f);

    }

    public List<Flight> getFlights()
    {
        TypedQuery<Flight> query = (TypedQuery<Flight>) em.createQuery("SELECT f FROM Flight f", Flight.class );
        List<Flight> results = query.getResultList();
        return results;
    }
    public Flight findByIdNamedQuery(int flightId)
    {
        Flight flight = em.createNamedQuery("Flight.findById", Flight.class)
                .setParameter("flightId", 2) // Тук използвайте правилното име на параметъра
                .getSingleResult();
        return flight;

        //        TypedQuery<Flight> query = em.createNamedQuery("Flight.findById", Flight.class);
        //        Flight flight = query.setParameter("filghtId", 2).getSingleResult();
    }
}
