package com.airline.controllers;

import com.airline.service.FlightLocal;
import com.airline.service.FlightRemote;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

//localhost:8080/JavaEE_EnterpriseJavaBeans-1.0-SNAPSHOT/FlightDetails <- change output dir
//localhost:8080/JavaEE_EnterpriseJavaBeans/FlightDetails
@WebServlet(name = "FlightDetails", value = "/FlightDetails")
public class FlightDetails extends HttpServlet
{
    //    @EJB
    //    private FlightServiceStatelessBean flightService;

   // @EJB(beanName = "flightStateful")
    private FlightLocal flightServiceStateful;
    //private FlightLocal flightService;

    @EJB(beanName = "flightStateless")
    private FlightLocal flightServiceStateless;

    //    @EJB
    //    private FlightRemote flightServiceRemote;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        out.println("The flights details servlet has been called..");

        out.println("Flight details" + flightServiceStateless.getFrom() + " to " + flightServiceStateless.getTo());
        //out.println("Flight details" + flightServiceStateful.getFrom() + " to " + flightServiceStateful.getTo());
        //        out.println("Flight details" + flightService.getFrom() + " to " + flightService.getTo());
        //        out.println("Flight details" + flightServiceRemote.getFrom() + " to " + flightServiceRemote.getTo());

        // Looking up EJBs through Java Naming and Directory Interface:
        //        try
        //        {
        //            Context context = new InitialContext();
        //            Object fObj = context.lookup("java:global/JavaEE_EnterpriseJavaBeans-1.0-SNAPSHOT/FlightServiceStatelessBean!com.airline.service.FlightServiceStatelessBean");
        //            flightService = (FlightServiceStatelessBean) fObj;
        //        }
        //        catch (NamingException e)
        //        {
        //            System.out.println("Naming Exception has occured when trying to lookup the FlightServiceStatelessBean EJB ");
        //            e.printStackTrace();
        //        }
        //        if(flightService != null)
        //        {
        //            out.println("Flight details " + flightService.getFrom() + " " + flightService.getTo()) ;
        //        }

        // Looking up Stateful EJBs through JNDI
        try
        {
            Context context = new InitialContext();
            Object fObj = context.lookup("java:global/JavaEE_EnterpriseJavaBeans/flightStateful!com.airline.service.FlightLocal");
            //"JavaEE_EnterpriseJavaBeans" = context root,
            // "flightStateful" = ejb name,
            // "com.airline.service.FlightLocal = fully qualified name"
            flightServiceStateful = (FlightLocal) fObj;
        }
        catch (NamingException e)
        {
            System.out.println("Naming Exception has occured when trying to lookup the FlightServiceStateful Bean EJB ");
            e.printStackTrace();
        }

        out.println("Flight details" + flightServiceStateful.getFrom() + " to " + flightServiceStateful.getTo());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}