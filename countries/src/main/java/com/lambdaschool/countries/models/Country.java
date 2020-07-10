package com.lambdaschool.countries.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {
    
    private String name;
    private long population;
    private long landmasskm2;
    private int medianage;



    public Country() {
    }

    public Country(String name, long population, long landmasskm2, int medianage) {
        this.name = name;
        this.population = population;
        this.landmasskm2 = landmasskm2;
        this.medianage = medianage;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return this.population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getLandmasskm2() {
        return this.landmasskm2;
    }

    public void setLandmasskm2(long landmasskm2) {
        this.landmasskm2 = landmasskm2;
    }

    public int getMedianage() {
        return this.medianage;
    }

    public void setMedianage(int medianage) {
        this.medianage = medianage;
    }

    public Country name(String name) {
        this.name = name;
        return this;
    }

    public Country population(long population) {
        this.population = population;
        return this;
    }

    public Country landmasskm2(long landmasskm2) {
        this.landmasskm2 = landmasskm2;
        return this;
    }

    public Country medianage(int medianage) {
        this.medianage = medianage;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", population='" + getPopulation() + "'" +
            ", landmasskm2='" + getLandmasskm2() + "'" +
            ", medianage='" + getMedianage() + "'" +
            "}";
    }


}