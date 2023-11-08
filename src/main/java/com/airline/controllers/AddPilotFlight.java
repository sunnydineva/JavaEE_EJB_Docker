package com.airline.controllers;

import com.airline.service.FlightService;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddPilotToFlight", value = "/AddPilotToFlight")
public class AddPilotFlight extends HttpServlet
{
    @EJB
    FlightService fs;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    String pid = request.getParameter("pid");
    String fid = request.getParameter("fid");

    fs.addPilotToFlight(pid, fid);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}