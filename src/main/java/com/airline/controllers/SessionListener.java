package com.airline.controllers;

import com.airline.service.CounterStatefulBean;

import javax.ejb.EJB;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

@WebListener
public class SessionListener implements  HttpSessionListener
{
    @EJB
    CounterStatefulBean counterStatefulBean;

    public SessionListener()
    {
    }
    @Override
    public void sessionCreated(HttpSessionEvent se)
    {
        /* Session is created. */
        HttpSession session = se.getSession();
        session.setAttribute("counterStatefulBean", counterStatefulBean);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se)
    {
        /* Session is destroyed. */
    }
}