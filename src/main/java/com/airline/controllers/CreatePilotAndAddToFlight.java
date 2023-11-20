package com.airline.controllers;

import com.airline.models.Pilot;
import com.airline.models.PilotRank;
import com.airline.service.PilotService;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreatePilotAndAddToFlight", value = "/CreatePilotAndAddToFlight")
public class CreatePilotAndAddToFlight extends HttpServlet
{
    @EJB
    PilotService ps;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //info from fancy_forms.jsp

        String fName = request.getParameter("first_name");
        String lName = request.getParameter("last_name");
        Integer license = Integer.parseInt(request.getParameter("license"));
        String rank = request.getParameter("pilot_rank");
        String flightId = request.getParameter("fid");

        Pilot p = new Pilot();

        p.setFirstName(fName);
        p.setLastName(lName);
        p.setPilotLicense(license);
        p.setPilotRank(PilotRank.valueOf(rank));

        //actual add pilot to flight
        ps.addNewPilotToFlight(p, flightId);

        response.sendRedirect("Flights");

    }
}