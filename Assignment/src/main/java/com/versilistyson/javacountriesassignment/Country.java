package com.versilistyson.javacountriesassignment;

public class Country {
    private String name;
    private int population;
    private long landMassSize;
    private long medianAge;

    public Country(String name, int population, long landMassSize, long medianAge) {
        this.name = name;
        this.population = population;
        this.landMassSize = landMassSize;
        this.medianAge = medianAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public long getLandMassSize() {
        return landMassSize;
    }

    public void setLandMassSize(long landMassSize) {
        this.landMassSize = landMassSize;
    }

    public long getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(long medianAge) {
        this.medianAge = medianAge;
    }
}
