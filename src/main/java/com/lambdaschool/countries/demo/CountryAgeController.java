package com.lambdaschool.countries.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

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
}
