package com.krishannattar.countryproject;

import java.util.concurrent.atomic.AtomicLong;

public class Country{

    private static final AtomicLong country = new AtomicLong();
    private long id;
    private String name;
    private long population;
    private int landMassSize;
    private int medianAge;

    public Country(String name, long population, int landMassSize, int medianAge)
    {
        this.id = country.incrementAndGet();
        this.name = name;
        this.population = population;
        this.landMassSize = landMassSize;
        this.medianAge = medianAge;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public int getLandMassSize() {
        return landMassSize;
    }

    public void setLandMassSize(int landMassSize) {
        this.landMassSize = landMassSize;
    }

    public int getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(int medianAge) {
        this.medianAge = medianAge;
    }
}
