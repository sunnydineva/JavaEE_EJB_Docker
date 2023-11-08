package com.airline.controllers;

import com.airline.models.Pilot;
import com.airline.models.PilotRank;
import com.airline.service.PilotService;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddPilot", value = "/AddPilot")
public class AddPilot extends HttpServlet
{
    @EJB
    PilotService ps;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Pilot p = new Pilot();
        p.setFirstName("Pilot");
        p.setLastName("Pilotski");
        p.setPilotRank(PilotRank.Captain);
        p.setPilotLicense(123456);

        ps.addPilot(p);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}