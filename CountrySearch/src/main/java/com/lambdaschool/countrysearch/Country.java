package com.lambdaschool.countrysearch;

import java.util.concurrent.atomic.AtomicLong;

public class Country
{
    //name, population, land mass size, median age , id
    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String countryName;
    private int population;
    private int landMassSize;
    private int medianAge;

    public Country( String countryName, int population, int landMassSize, int medianAge) {
        this.id = counter.incrementAndGet();
        this.countryName = countryName;
        this.population = population;
        this.landMassSize = landMassSize;
        this.medianAge = medianAge;
    }

    public Country (Country toClone)
    {
        this.id = toClone.getId();
        this.countryName = toClone.getCountryName();
        this.population = toClone.getPopulation();
        this.landMassSize = toClone.getLandMassSize();
        this.medianAge = toClone.getMedianAge();
    }

    public long getId() {
        return id;
    }


    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
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
