package com.airline.controllers;

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
        //        Passenger p = new Passenger();

        //        p.setFirstName("Sunny");
        //        p.setLastName("Dineva");
        //
        //        Calendar cal = Calendar.getInstance();
        //        cal.set(Calendar.YEAR, 1983);
        //        cal.set(Calendar.MONTH, 12);
        //        cal.set(Calendar.DATE, 9);
        //
        //        Date dob = cal.getTime();
        //
        //        p.setDob(dob);
        //        p.setGender(Gender.Female);
        //        p.setFlightClass(FlightClass.Business);

        //        passengerService.addPassenger(p);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Passenger p = new Passenger();

        String fName = request.getParameter("first_name");
        p.setFirstName(fName);

        String lName = request.getParameter("last_name");
        p.setLastName(lName);

        String dob_raw = request.getParameter("dob"); //5/17/1990

        String[] dobArr = dob_raw.split("\\/");

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.parseInt(dobArr[2]));
        cal.set(Calendar.MONTH, Integer.parseInt(dobArr[0]) - 1); //January=0,February=1..., December=11 => -1
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dobArr[0]));

        Date dob = cal.getTime();

        p.setDob(dob);

        String gender = request.getParameter("gender");
        p.setGender(Gender.valueOf(gender));

        passengerService.addPassenger(p);

        response.sendRedirect("Passengers");
    }
}