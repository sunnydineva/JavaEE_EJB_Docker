package com.airline.service;

import com.airline.models.Pilot;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
