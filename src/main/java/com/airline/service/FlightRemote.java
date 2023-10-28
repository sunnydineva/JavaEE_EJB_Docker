package com.airline.service;

import javax.ejb.Remote;

@Remote
public interface FlightRemote
{
    public Integer getId();

    public void setId(Integer id);

    public String getFrom();

    public void setFrom(String from);

    public String getTo();

    public void setTo(String to);

    public Integer getPrice();

    public void setPrice(Integer price);

    public Integer getNumOfSeats();

    public void setNumOfSeats(Integer numOfSeats);

    public String getAirplaneModel();

    public void setAirplaneModel(String airplaneModel);

    @Override
    public String toString();
}
