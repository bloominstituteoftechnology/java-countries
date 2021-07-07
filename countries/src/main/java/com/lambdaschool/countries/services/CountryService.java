package com.lambdaschool.countries.services;


import java.util.List;

import com.lambdaschool.countries.models.Country;

public interface CountryService {


    // Returns all Countries Names in Alphabetical Order
    List<Country> countriesAlphabetical();


    // Returns list of Countries Names that begin with the given Letter
    List<Country> filterCountriesByGivenLetter(char letter);


    // Returns the populations Total
    long populationTotal();

    // Returns the country with the smallest population
    Country smallestPop();

    // Returns teh country with the largest population
    Country largestPop();




}