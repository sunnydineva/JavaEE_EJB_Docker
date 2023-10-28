package com.airline.service;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class FlightServiceStatelessBean
 */
@Stateless(name="flightStateless")
//@LocalBean <- remove it when add @Local on FlightLocal
public class FlightServiceStatelessBean implements FlightLocal, FlightRemote
{
    public FlightServiceStatelessBean()
    {
    }

    private Integer id = 2348646;
    private String from = "Los Angelis";
    private String to = "London";
    private Integer price = 400;
    private Integer numOfSeats = 400;
    private String airplaneModel = "Boing 707";

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getFrom()
    {
        return from;
    }

    public void setFrom(String from)
    {
        this.from = from;
    }

    public String getTo()
    {
        return to;
    }

    public void setTo(String to)
    {
        this.to = to;
    }

    public Integer getPrice()
    {
        return price;
    }

    public void setPrice(Integer price)
    {
        this.price = price;
    }

    public Integer getNumOfSeats()
    {
        return numOfSeats;
    }

    public void setNumOfSeats(Integer numOfSeats)
    {
        this.numOfSeats = numOfSeats;
    }

    public String getAirplaneModel()
    {
        return airplaneModel;
    }

    public void setAirplaneModel(String airplaneModel)
    {
        this.airplaneModel = airplaneModel;
    }

    @Override
    public String toString()
    {
        return "FlightServiceStatelessBean{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", price=" + price +
                ", numOfSeats=" + numOfSeats +
                ", airplaneModel='" + airplaneModel + '\'' +
                '}';
    }
}
