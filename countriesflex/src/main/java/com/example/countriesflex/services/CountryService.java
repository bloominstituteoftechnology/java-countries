package com.example.countriesflex.services;

import com.example.countriesflex.models.Country;

import java.util.List;

public interface CountryService {

    List<Country> getAllCountries();
    List<Country> countriesByLetter(char letter);
    long getPopulationTotal();
    Country getMinPopulation();
    Country getMaxPopulation();

}
