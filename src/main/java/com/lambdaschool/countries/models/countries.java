package com.lambdaschool.countries.models;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class countries {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long countryid;
    private String name;
    private long population;
    private long landmasskm2;
    private int medianage;

    public countries() {
    }

    public countries(long countryid, String name, long poulation, long landmasskm2, int medianage) {
        this.countryid=countryid;
        this.name = name;
        this.population = poulation;
        this.landmasskm2 = landmasskm2;
        this.medianage = medianage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPoulation() {
        return population;
    }

    public void setPoulation(long poulation) {
        this.population = poulation;
    }

    public long getLandmasskm2() {
        return landmasskm2;
    }

    public void setLandmasskm2(long landmasskm2) {
        this.landmasskm2 = landmasskm2;
    }

    public int getMedianage() {
        return medianage;
    }

    public void setMedianage(int medianage) {
        this.medianage = medianage;
    }

    public long getCountryid() {
        return countryid;
    }

    public void setCountryid(long countryid) {
        this.countryid = countryid;
    }
}
