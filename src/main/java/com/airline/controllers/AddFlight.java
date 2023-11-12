package com.airline.controllers;

import com.airline.models.Airplane;
import com.airline.models.Flight;
import com.airline.models.FlightDestinations;
import com.airline.service.FlightService;

import javax.ejb.EJB;
import javax.persistence.criteria.CriteriaBuilder;
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

        // Old hardcoded methods
        //        Flight f = new Flight();
        //        f.setFlightOrigin(FlightDestinations.Amsterdam);
        //        f.setFlightDestination(FlightDestinations.London);
        //        f.setPrice(400);
        //
        //        Calendar cal = Calendar.getInstance();
        //        cal.set(Calendar.YEAR, 2014);
        //        cal.set(Calendar.MONTH, 10);
        //        cal.set(Calendar.HOUR_OF_DAY, 19);
        //        cal.set(Calendar.MINUTE, 0);
        //
        //        Date flightTime = cal.getTime();
        //
        //        System.out.println(flightTime);
        //
        //        f.setFlightTime(flightTime);
        //
        //        Airplane a = new Airplane();
        //        a.setModelName("787");
        //        a.setPlaneMake("Boeing");
        //        a.setSeatingCapacity(250);
        //
        //        f.setAirplaneDetails(a);
        //
        //        System.out.println(f);
        //        System.out.println(a);
        //
        //        fs.addFlight(f, a);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        Flight f = new Flight();

        //info from the form:

        String from_destination = request.getParameter("from_destination");
        f.setFlightOrigin(FlightDestinations.valueOf(from_destination));

        String to_destination = request.getParameter("to_destination");
        f.setFlightDestination(FlightDestinations.valueOf(to_destination));

        String price = request.getParameter("price");
        f.setPrice(Integer.parseInt(price));

        Integer year = Integer.parseInt(request.getParameter("year"));
        Integer month = Integer.parseInt(request.getParameter("month"));
        Integer day = Integer.parseInt(request.getParameter("day"));
        Integer hour = Integer.parseInt(request.getParameter("hour"));
        Integer minute = Integer.parseInt(request.getParameter("minute"));
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);

        Date flightTime = cal.getTime();

        System.out.println(flightTime);

        f.setFlightTime(flightTime);

        Airplane a = new Airplane();

        a.setModelName(request.getParameter("airplane_model"));
        a.setPlaneMake(request.getParameter("airplane_make"));
        a.setSeatingCapacity(Integer.parseInt(request.getParameter("airplane_seating")));

        f.setAirplaneDetails(a);

        System.out.println(f);
        System.out.println(a);

        fs.addFlight(f, a);

        response.sendRedirect("Flights");
    }
}