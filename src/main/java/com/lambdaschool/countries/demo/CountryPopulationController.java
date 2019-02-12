package com.lambdaschool.countries.demo;

import com.sun.source.tree.CompilationUnitTree;
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

    @RequestMapping("/min")
    public Country smallestCountry()
    {
        Country smallest = CountriesApplication.countryList.countryList.stream().min(Comparator.comparing(c -> c.getPopulation())).get();
        return smallest;
    }

    @RequestMapping("/max")
    public Country biggestCountry()
    {
        Country biggest = CountriesApplication.countryList.countryList.stream().max(Comparator.comparing(c -> c.getPopulation())).get();
        return biggest;
    }

}
