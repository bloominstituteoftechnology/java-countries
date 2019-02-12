package com.lambdaschool.countries.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@RestController
@RequestMapping("/population")
public class CountryPopulationController
{
    @RequestMapping("/size")
    public ArrayList<Country> filteredByPopulation(@RequestParam(value="people") long people)
    {
        ArrayList<Country> filtered = new ArrayList<>(CountriesApplication.countryList.countryList);
        filtered.removeIf(c -> c.getPopulation() < people );
        return filtered;
    }
}
