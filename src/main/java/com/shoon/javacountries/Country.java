package com.shoon.javacountries;

import java.util.concurrent.atomic.AtomicInteger;

public class Country {
    private static final AtomicInteger iCounter = new AtomicInteger();
    private int iID;
    private String strName;
    private int iPopulation;

    private int iSize;
    private int iMedianAge;

    public Country(String strName, int iPopulation, int iSize, int iMedianAge) {
        this.iID = iCounter.incrementAndGet();
        this.strName = strName;
        this.iPopulation = iPopulation;
        this.iSize = iSize;
        this.iMedianAge = iMedianAge;
    }

    public int getID() {
        return iID;
    }



    public String getName() {
        return strName;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public int getPopulation() {
        return iPopulation;
    }

    public void setPopulation(int iPopulation) {
        this.iPopulation = iPopulation;
    }

    public int getSize() {
        return iSize;
    }

    public void setSize(int iSize) {
        this.iSize = iSize;
    }

    public int getMedianAge() {
        return iMedianAge;
    }

    public void setMedianAge(int iMedianAge) {
        this.iMedianAge = iMedianAge;
    }
}
