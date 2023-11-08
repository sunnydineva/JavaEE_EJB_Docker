package com.airline.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NamedQuery(name="Flight.findById", query = "SELECT f from Flight f where f.id = :flightID")
@Entity
@Table(name = "flights")
public class Flight implements Serializable
{

    private static final long serialVersionUID = 7844327350975052680L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private FlightDestinations flightOrigin;

    @Enumerated(EnumType.STRING)
    private FlightDestinations flightDestination;

    private Integer price;

    @Temporal(TemporalType.TIMESTAMP)
    private Date flightTime;

    @OneToOne //???!!!
    @JoinColumn(name = "airplane_fk")
    private Airplane airplane;

    @OneToMany(mappedBy = "flightForPilot")
    private List<Pilot> pilots;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public FlightDestinations getFlightOrigin()
    {
        return flightOrigin;
    }

    public void setFlightOrigin(FlightDestinations flightOrigin)
    {
        this.flightOrigin = flightOrigin;
    }

    public FlightDestinations getFlightDestination()
    {
        return flightDestination;
    }

    public void setFlightDestination(FlightDestinations flightDestination)
    {
        this.flightDestination = flightDestination;
    }

    public Integer getPrice()
    {
        return price;
    }

    public void setPrice(Integer price)
    {
        this.price = price;
    }

    public Date getFlightTime()
    {
        return flightTime;
    }

    public void setFlightTime(Date flightTime)
    {
        this.flightTime = flightTime;
    }

    public Airplane getAirplaneDetails()
    {
        return airplane;
    }

    public void setAirplaneDetails(Airplane airplaneDetails)
    {
        this.airplane = airplaneDetails;
    }

    public List<Pilot> getPilots()
    {
        return pilots;
    }

    public void setPilots(List<Pilot> pilots)
    {
        this.pilots = pilots;
    }

    @Override
    public String toString()
    {
        return "Flight{" +
                "id=" + id +
                ", flightOrigin=" + flightOrigin +
                ", flightDestination=" + flightDestination +
                ", price=" + price +
                ", flightTime=" + flightTime +
                ", airplane=" + airplane +
                ", pilots=" + pilots +
                '}';
    }
}
