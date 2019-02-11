package com.joshuahalvorson.webcountries;

public class Country {
    private String name;
    private long landMass;
    private int medianAge;

    public Country(String name, long landMass, int medianAge) {
        this.name = name;
        this.landMass = landMass;
        this.medianAge = medianAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getLandMass() {
        return landMass;
    }

    public void setLandMass(long landMass) {
        this.landMass = landMass;
    }

    public int getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(int medianAge) {
        this.medianAge = medianAge;
    }
}
