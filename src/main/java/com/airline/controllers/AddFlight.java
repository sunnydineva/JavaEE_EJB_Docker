package com.airline.controllers;

import com.airline.models.Airplane;
import com.airline.models.Flight;
import com.airline.models.FlightDestinations;
import com.airline.service.FlightService;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

@WebServlet(name = "AddFlight", value = "/AddFlight")
public class AddFlight extends HttpServlet
{
    @EJB
    FlightService fs;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Flight f = new Flight();
        f.setFlightOrigin(FlightDestinations.Amsterdam);
        f.setFlightDestination(FlightDestinations.London);
        f.setPrice(400);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2014);
        cal.set(Calendar.MONTH, 10);
        cal.set(Calendar.HOUR_OF_DAY, 19);
        cal.set(Calendar.MINUTE, 0);

        Date flightTime = cal.getTime();

        System.out.println(flightTime);

        f.setFlightTime(flightTime);

        Airplane a = new Airplane();
        a.setModelName("787");
        a.setPlaneMake("Boeing");
        a.setSeatingCapacity(250);

        f.setAirplaneDetails(a);

        System.out.println(f);
        System.out.println(a);

        fs.addFlight(f, a);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}