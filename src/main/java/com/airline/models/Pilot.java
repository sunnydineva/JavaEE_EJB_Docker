package com.airline.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;

@NamedQuery(name="Pilot.findByIdSomeNAME", query = "SELECT p FROM Pilot p WHERE p.id = :pilotID")
@Entity
@Table(name = "pilots")
public class Pilot implements Serializable
{

    private static final long serialVersionUID = -8833576989570880269L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private Integer pilotLicense;

    @Enumerated(EnumType.STRING)
    private PilotRank pilotRank;

    @ManyToOne
    @JoinColumn(name = "flight_fk")
    private Flight flightForPilot;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Integer getPilotLicense()
    {
        return pilotLicense;
    }

    public void setPilotLicense(Integer pilotLicense)
    {
        this.pilotLicense = pilotLicense;
    }

    public PilotRank getPilotRank()
    {
        return pilotRank;
    }

    public void setPilotRank(PilotRank pilotRank)
    {
        this.pilotRank = pilotRank;
    }

    public Flight getFlightForPilot()
    {
        return flightForPilot;
    }

    public void setFlightForPilot(Flight flightForPilot)
    {
        this.flightForPilot = flightForPilot;
    }
}
