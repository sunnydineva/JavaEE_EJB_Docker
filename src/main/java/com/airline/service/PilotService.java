package com.airline.service;

import com.airline.models.Flight;
import com.airline.models.Pilot;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class PilotService
{
    public PilotService()
    {
    }
    @PersistenceContext(unitName = "airline_persistence_unit")
    EntityManager em;

    public void addPilot(Pilot p)
    {
        em.persist(p);
    }

    public void addNewPilotToFlight(Pilot p, String flightId)
    {

        //takes the pilot from CreatePilotAndAddToFlight servlet

        em.persist(p);

        TypedQuery<Flight> flightTypedQuery = em.createNamedQuery("Flight.findById", Flight.class);
        flightTypedQuery.setParameter("flightID", Integer.parseInt(flightId));

        Flight f = flightTypedQuery.getSingleResult();

        List<Pilot> pilotList = f.getPilots();
        pilotList.add(p);
        //        f.setPilots(pilotList); //redundant

        p.setFlightForPilot(f);
    }
}
