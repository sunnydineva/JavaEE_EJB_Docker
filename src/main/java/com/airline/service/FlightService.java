package com.airline.service;

import com.airline.models.Airplane;
import com.airline.models.Flight;
import com.airline.models.Pilot;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
        em.persist(a);
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
