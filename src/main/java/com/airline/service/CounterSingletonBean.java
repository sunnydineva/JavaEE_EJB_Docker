package com.airline.service;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class CounterSingletonBean
{
    Integer count = 0;
    public CounterSingletonBean()
    {
    }

    public Integer getCount()
    {
        return count;
    }

    public void setCount(Integer count)
    {
        this.count = count;
    }

    public void addOneToCount()
    {
        this.count ++;
    }
}
