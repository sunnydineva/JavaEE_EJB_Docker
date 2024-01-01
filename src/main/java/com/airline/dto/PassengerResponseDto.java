package com.airline.dto;

import com.airline.models.FlightClass;
import com.airline.models.Gender;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@XmlRootElement //for MediaType.APPLICATION.XML
public class PassengerResponseDto implements Serializable
{
    private Integer id;

    private String firstName;

    private String lastName;

    private Date dob;

    private Gender gender;

    private FlightClass flightClass;

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

    public PassengerResponseDto()
    {
    }
}
