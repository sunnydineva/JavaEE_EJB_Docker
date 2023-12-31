package com.airline.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Entity implementation class for Entity: Passenger
 */

@Entity
@Table(name = "passengers")
@XmlRootElement //for MediaType.APPLICATION.XML
public class Passenger implements Serializable
{
    @Transient //to not represent a column of our DB
    private static final long serialVersionUID = 3127477484667719968L;

    public Passenger()
    {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private FlightClass flightClass;

    @ManyToMany(mappedBy = "passengers")
    private List<Flight> flights; //the flight tickets the passenger has

    public Integer getId()
    {
        return id;
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

    public Date getDob()
    {
        return dob;
    }

    public void setDob(Date dob)
    {
        this.dob = dob;
    }

    public Gender getGender()
    {
        return gender;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    public FlightClass getFlightClass()
    {
        return flightClass;
    }

    public void setFlightClass(FlightClass flightClass)
    {
        this.flightClass = flightClass;
    }

     public List<Flight> getFlights()
    {
        return flights;
    }

    public void setFlights(List<Flight> flights)
    {
        this.flights = flights;
    }

    @Override
    public String toString()
    {
        return "Passenger{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", gender=" + gender +
                ", flightClass=" + flightClass +
                ", flights=" + flights +
                '}';
    }
}
