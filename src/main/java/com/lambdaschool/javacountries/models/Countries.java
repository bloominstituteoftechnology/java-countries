package com.lambdaschool.javacountries.models;


import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Countries {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long countryid;
    private String name;
    private int population;
    private int landmasskm2;
    private int medianage;

    public Countries(String name, int population, int landmasskm2, int medianage) {
        this.name = name;
        this.population = population;
        this.landmasskm2 = landmasskm2;
        this.medianage = medianage;
    }

    public Countries() {
        //required by JPA
    }

    public long getCountryid() {
        return countryid;
    }

    public void setCountryid(long countryid) {
        this.countryid = countryid;
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

    public int getLandmasskm2() {
        return landmasskm2;
    }

    public void setLandmasskm2(int landmasskm2) {
        this.landmasskm2 = landmasskm2;
    }

    public int getMedianage() {
        return medianage;
    }

    public void setMedianage(int medianage) {
        this.medianage = medianage;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "countryid=" + countryid +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", landmasskm2=" + landmasskm2 +
                ", medianage=" + medianage +
                '}';
    }
}
