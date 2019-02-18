package com.lambdaschool.countries;

// fields needed: Name, Population, Land Mass in Km2, Median Age

import java.util.concurrent.atomic.AtomicLong;

public class Country
{
    // fields
    private static final AtomicLong counter = new AtomicLong();
    private final long id;
    private final String name;
    private final int population;
    private final int landMass;
    private final int medianAge;

    // constructor
    public Country(String name, int population, int landMass, int medianAge)
    {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.population = population;
        this.landMass = landMass;
        this.medianAge = medianAge;
    }

    // getters & setters------------------------------------------------

    // gets ID
    public long getId()
    {
        return id;
    }

    // gets name
    public String getName()
    {
        return name;
    }

    // sets name
    public void setName(String name)
    {
        this.name = name;
    }

    // gets population
    public int getPopulation()
    {
        return population;
    }

    // since population can change
    public void setPopulation(int population)
    {
        this.population = population;
    }

    // gets landmass
    public int getLandMass()
    {
        return landMass;
    }

    // gets medianAge
    public int getMedianAge()
    {
        return medianAge;
    }
}
