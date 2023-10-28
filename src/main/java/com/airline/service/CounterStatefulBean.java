package com.airline.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

@Stateful
@LocalBean
public class CounterStatefulBean
{
    Integer count = 0;
    public CounterStatefulBean()
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
