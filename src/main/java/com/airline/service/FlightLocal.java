package com.airline.service;

import javax.ejb.Local;

//name must be unique in the deployed apps, not only for the project
@Local
public interface FlightLocal
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