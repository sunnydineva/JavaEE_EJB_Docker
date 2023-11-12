package com.airline.controllers;

import com.airline.models.Passenger;
import com.airline.service.PassengerService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Passengers", value = "/Passengers")
public class Passengers extends HttpServlet
{
    @EJB
    PassengerService ps;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<Passenger> pList =ps.getPassengers();
        request.setAttribute("passengers_list", pList);

        PrintWriter out = response.getWriter();
        out.println("List of passengers will be displayed here...");

        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/passengers_list.jsp");
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}