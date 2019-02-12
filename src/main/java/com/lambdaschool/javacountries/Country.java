package com.lambdaschool.javacountries;

import org.springframework.web.servlet.mvc.method.annotation.UriComponentsBuilderMethodArgumentResolver;

import java.util.Comparator;

public class Country{
    private String name;
    private int population, landMass, medianAge;

    Country(){}

    public Country(String name, int population, int landMass, int medianAge) {
        this.name = name;
        this.population = population;
        this.landMass = landMass;
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

    public int getLandMass() {
        return landMass;
    }

    public void setLandMass(int landMass) {
        this.landMass = landMass;
    }

    public int getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(int medianAge) {
        this.medianAge = medianAge;
    }

//    public static Comparator<Country> CountryNameComparator = new Comparator<Country>() {
//        @Override
//        public int compare(Country o1, Country o2) {
//            String countryName1 = o1.getName().toLowerCase();
//            String countryName2 = o2.getName().toLowerCase();
//
//            return countryName1.compareTo(countryName2);
//        }
//    };
//
//    public static Comparator<Country> CountryAgeComparator = new Comparator<Country>() {
//        @Override
//        public int compare(Country o1, Country o2) {
//            return 0;
//        }
//    };


}
