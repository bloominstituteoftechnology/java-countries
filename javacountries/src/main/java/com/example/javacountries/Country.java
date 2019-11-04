package com.example.javacountries;

import java.util.concurrent.atomic.AtomicLong;

public class Country {

    //counter for id, AtomicLong creates new instance of an id
    private static final AtomicLong counter = new AtomicLong();
/*
a country name, population,
land mass size, and median age*/
    private long id;
    private String country_name;
    private long population;
    private long landmass_size;
    private int median_age;

    public Country(String country_name, long population, long landmass_size, int median_age) {
        this.id = counter.incrementAndGet();
        this.country_name = country_name;
        this.population = population;
        this.landmass_size = landmass_size;
        this.median_age = median_age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getLandmass_size() {
        return landmass_size;
    }

    public void setLandmass_size(long landmass_size) {
        this.landmass_size = landmass_size;
    }

    public int getMedian_age() {
        return median_age;
    }

    public void setMedian_age(int median_age) {
        this.median_age = median_age;
    }
}
