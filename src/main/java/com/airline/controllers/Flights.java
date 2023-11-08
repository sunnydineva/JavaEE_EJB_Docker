package com.airline.controllers;

import com.airline.models.Flight;
import com.airline.service.FlightService;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Flights", value = "/Flights")
public class Flights extends HttpServlet
{
    @EJB
    FlightService fs;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<Flight> fList =fs.getFlights();
        request.setAttribute("flight_list", fList);

        PrintWriter out = response.getWriter();
        out.println("List of flights will be displayed here...");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}