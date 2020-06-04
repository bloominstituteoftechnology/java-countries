package com.lambdaschool.countries;

import java.util.concurrent.atomic.AtomicLong;

public class Country {
    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String name;
    private int population;
    private double km2;
    private int age;

    public Country( String name, int population, double km2, int age) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.population = population;
        this.km2 = km2;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public double getKm2() {
        return km2;
    }

    public void setKm2(double km2) {
        this.km2 = km2;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", km2=" + km2 +
                ", age=" + age +
                '}';
    }
}
