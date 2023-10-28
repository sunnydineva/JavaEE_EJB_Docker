package com.airline.controllers;

import com.airline.service.CounterSingletonBean;
import com.airline.service.CounterStatefulBean;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShowCount", value = "/ShowCount")

public class ShowCount extends HttpServlet
{
    private static final long serialVersionUID = 7041807814028902177L;

    @EJB
    CounterSingletonBean counterSingletonBean;

//    @EJB
//    CounterStatefulBean counterStatefulBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        CounterStatefulBean counterStatefulBean = (CounterStatefulBean) session.getAttribute("counterStatefulBean");


        PrintWriter out = response.getWriter();
        out.println("The current count value for the SINGLETON BEAN is: " + counterSingletonBean.getCount());

        out.println("The current count value for the STATEFUL BEAN is: " + counterStatefulBean.getCount());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}