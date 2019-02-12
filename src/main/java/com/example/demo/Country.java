package com.example.demo;

public class Country {

    private String name;
    private long population, landMass, age;

    public Country(String name, long population, long landMass, long age) {
        this.name = name;
        this.population = population;
        this.landMass = landMass;
        this.age = age;
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

    public long getLandMass() {
        return landMass;
    }

    public void setLandMass(long landMass) {
        this.landMass = landMass;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }
}
