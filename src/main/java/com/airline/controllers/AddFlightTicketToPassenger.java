package com.airline.controllers;

import com.airline.service.PassengerService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddFlightTicketToPassenger", value = "/AddFlightTicketToPassenger")
public class AddFlightTicketToPassenger extends HttpServlet
{
    @EJB
    PassengerService ps;
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

       ps.addFlightTicketToPassenger(fid, pid);

        response.sendRedirect("Passengers");
    }
}