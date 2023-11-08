package com.airline.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "airplanes")
public class Airplane implements Serializable
{

    private static final long serialVersionUID = 6007409707751148822L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String planeMake;

    private String modelName;

    private Integer seatingCapacity;

    @OneToOne(mappedBy = "airplane") //??????!!!!
    private Flight flight;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getPlaneMake()
    {
        return planeMake;
    }

    public void setPlaneMake(String planeMake)
    {
        this.planeMake = planeMake;
    }

    public String getModelName()
    {
        return modelName;
    }

    public void setModelName(String modelName)
    {
        this.modelName = modelName;
    }

    public Flight getFlight()
    {
        return flight;
    }

    public void setFlight(Flight flight)
    {
        this.flight = flight;
    }

    public Integer getSeatingCapacity()
    {
        return seatingCapacity;
    }

    public void setSeatingCapacity(Integer seatingCapacity)
    {
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public String toString()
    {
        return "Airplane{" +
                "id=" + id +
                ", planeMake='" + planeMake + '\'' +
                ", modelName='" + modelName + '\'' +
                ", seatingCapacity=" + seatingCapacity +
                ", flight=" + flight +
                '}';
    }
}
