package com.lambdaschool.countries.demo;

import java.util.concurrent.atomic.AtomicLong;

public class Country {
    private static final AtomicLong counter = new AtomicLong();
    private  long id;
    private String name;
    private long population;
    private double landMassSize;
    private double medianAge;

    public Country(String name, long population, double landMassSize, double medianAge) {
        this.id = counter.incrementAndGet();
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

    public double getLandMassSize() {
        return landMassSize;
    }

    public void setLandMassSize(double landMassSize) {
        this.landMassSize = landMassSize;
    }

    public double getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(double medianAge) {
        this.medianAge = medianAge;
    }

}
