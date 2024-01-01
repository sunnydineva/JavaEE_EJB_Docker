package com.airline.dto;

import com.airline.models.FlightDestinations;
import java.io.Serializable;
import java.util.Date;

public class FlightResponseDto implements Serializable
{
    private Integer id;

    private FlightDestinations flightOrigin;

    private FlightDestinations flightDestination;

    private Integer price;

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

    private Date flightTime;

    public FlightResponseDto(Integer id, FlightDestinations flightOrigin, FlightDestinations flightDestination, Integer price, Date flightTime)
    {
        this.id = id;
        this.flightOrigin = flightOrigin;
        this.flightDestination = flightDestination;
        this.price = price;
        this.flightTime = flightTime;
    }

    public FlightResponseDto()
    {
    }

    @Override
    public String toString()
    {
        return "FlightResponseDto{" +
                "id=" + id +
                ", flightOrigin=" + flightOrigin +
                ", flightDestination=" + flightDestination +
                ", price=" + price +
                ", flightTime=" + flightTime +
                '}';
    }
}
