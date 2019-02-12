package com.lambdaschool.javacountries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/population")
public class CountryPopulationController {

    @RequestMapping("/size")
    public List<Country> getCountrieswithMedianPopGreaterThanEqualTo(@RequestParam(value = "people") String population)
    {
        JavaCountriesApplication.listcountry.countryList.sort(Comparator.comparingInt(Country::getPopulation));

        return JavaCountriesApplication.listcountry.countryList
                .stream()
                .filter((c) -> c.getPopulation() >= Integer.parseInt(population))
                .collect(Collectors.toList());
    }

    @RequestMapping("/min")
    public Country getCountrywithLowestPopulation()
    {

        return JavaCountriesApplication.listcountry.countryList
                .stream()
                .min(Comparator.comparing(Country::getPopulation))
                .orElseThrow(NoSuchElementException::new);
    }

    @RequestMapping("/max")
    public Country getCountryWithGreatestPopulation()
    {
        return JavaCountriesApplication.listcountry.countryList
                .stream()
                .max(Comparator.comparing(Country::getPopulation))
                .orElseThrow(NoSuchElementException::new);
    }
}
