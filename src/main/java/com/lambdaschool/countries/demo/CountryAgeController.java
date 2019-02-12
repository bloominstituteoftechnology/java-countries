package com.lambdaschool.countries.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;

@RestController
@RequestMapping("/age")
public class CountryAgeController
{
    @RequestMapping("/age")
    public ArrayList<Country> filteredByAge(@RequestParam(value="age") double age)
    {
        ArrayList<Country> filtered = new ArrayList<>(CountriesApplication.countryList.countryList);
        filtered.removeIf(c -> c.getMedianAge() < age );
        return filtered;
    }

    @RequestMapping("/min")
    public Country smallestMedianAge()
    {
        Country smallest = CountriesApplication.countryList.countryList.stream().min(Comparator.comparing(c -> c.getMedianAge())).get();
        return smallest;
    }

    @RequestMapping("/max")
    public Country biggestMedianAge()
    {
        Country biggest = CountriesApplication.countryList.countryList.stream().max(Comparator.comparing(c -> c.getMedianAge())).get();
        return biggest;
    }
}
