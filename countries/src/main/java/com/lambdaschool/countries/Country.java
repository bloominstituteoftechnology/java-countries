package com.lambdaschool.countries;

import java.io.StringBufferInputStream;
import java.util.concurrent.atomic.AtomicLong;

public class Country

    //Name, Populations, Land Mass in Km2, Median Age

{
    //create fields

    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String countryName;
    private int populations;
    private int landMass;
    private int medianAge;

    //constructor

    public Country(String countryName, int populations, int landMass, int medianAge)
    {
        this.id = counter.incrementAndGet();
        this.countryName = countryName;
        this.populations = populations;
        this.landMass = landMass;
        this.medianAge = medianAge;
    }

    //default constructor
    public Country()
    {
        //MUST BE HERE, BUT LEAVE EMPTY
    }

    public long getId() // always want to get the id never set it
    {
        return id;
    }

    public String getCountryName()
    {
        return countryName;
    }

    public void setCountryName(String countryName)
    {
        this.countryName = countryName;
    }

    public int getPopulations()
    {
        return populations;
    }

    public void setPopulations(int populations)
    {
        this.populations = populations;
    }

    public int getLandMass()
    {
        return landMass;
    }

    public void setLandMass(int landMass)
    {
        this.landMass = landMass;
    }

    public int getMedianAge()
    {
        return medianAge;
    }

    public void setMedianAge(int medianAge)
    {
        this.medianAge = medianAge;
    }

    @Override
    public String toString()
    {
        return "Country{" + "id=" + id + ", countryName='" + countryName + '\'' + ", populations=" + populations + ", landMass=" + landMass + ", medianAge=" + medianAge + '}';
    }

}


//static allos the id counter to be shared across objects
//final is very similar to a const. Once it is assigned a value,
//it cannot be changed

