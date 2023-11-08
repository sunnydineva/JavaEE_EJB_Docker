package com.airline.controllers;

import com.airline.models.FlightClass;
import com.airline.models.Gender;
import com.airline.models.Passenger;
import com.airline.service.PassengerService;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

@WebServlet(name = "AddPassenger", value = "/AddPassenger")
public class AddPassenger extends HttpServlet
{
    @EJB
    PassengerService passengerService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Passenger p = new Passenger();

        p.setFirstName("Sunny");
        p.setLastName("Dineva");

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1983);
        cal.set(Calendar.MONTH, 12);
        cal.set(Calendar.DATE, 9);

        Date dob = cal.getTime();

        p.setDob(dob);
        p.setGender(Gender.Female);
        p.setFlightClass(FlightClass.Business);

        passengerService.addPassenger(p);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}