package com.lambdaschool.javacountries;

public class Country
{
    //fields
    private String name;
    private int population;
    private int land;
    private int medianAge;
    //constructor!
    public Country(String name, int population, int land, int medianAge) {
        this.name = name;
        this.population = population;
        this.land = land;
        this.medianAge = medianAge;
    }

    //    public Countries(Countries to Clone)





    //Methods...
    //getters (since not setting any data)

    public String getName() {
        return name.toUpperCase();
    }

    public int getPopulation() {
        return population;
    }

    public int getLand() {
        return land;
    }

    public int getMedianAge() {
        return medianAge;
    }
    //toString method

    @Override
    public String toString() {
        return "Country{" + "name='" + name + '\'' + ", population=" + population + ", land=" + land + ", medianAge=" + medianAge + '}';
    }


}
