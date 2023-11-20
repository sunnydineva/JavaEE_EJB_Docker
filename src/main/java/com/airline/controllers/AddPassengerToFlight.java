package com.airline.controllers;

import com.airline.models.Flight;
import com.airline.service.FlightService;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddPassengerToFlight", value = "/AddPassengerToFlight")
public class AddPassengerToFlight extends HttpServlet
{
    @EJB
    FlightService fs;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //from fancy_forms.jsp
        String fid = request.getParameter("fid");
        String pid = request.getParameter("pid");

        fs.addPassengerToFlight(pid, fid);

        response.sendRedirect("Flights");
    }
}