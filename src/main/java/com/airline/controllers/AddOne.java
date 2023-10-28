package com.airline.controllers;

import com.airline.service.CounterSingletonBean;
import com.airline.service.CounterStatefulBean;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddOne", value = "/AddOne")
public class AddOne extends HttpServlet
{
    @EJB
    CounterSingletonBean counterSingletonBean;

//    @EJB
//    CounterStatefulBean counterStatefulBean; //will add it through the Session

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        CounterStatefulBean counterStatefulBean = (CounterStatefulBean) session.getAttribute("counterStatefulBean");


        PrintWriter out = response.getWriter();
        out.println("The current count value for the SINGLETON BEAN is: " + counterSingletonBean.getCount());

        out.println("The current count value for the STATEFUL BEAN is: " + counterStatefulBean.getCount());

        counterSingletonBean.addOneToCount();
        out.println("The count was incremented by one. The current count value FOR THE SINGLETON BEAN is: " + counterSingletonBean.getCount());

        counterStatefulBean.addOneToCount();
        out.println("The count was incremented by one. The current count value FOR THE STATEFUL BEAN is: " + counterStatefulBean.getCount());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}