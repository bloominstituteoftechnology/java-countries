package com.lambdaschool.countries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/data")

public class CountryController
{
    // http://localhost:8080/data/country?id=1 (return specific country by id)
    @RequestMapping("/country")
    public Country getCountryDetail(@RequestParam(value="id") long id)
    {
        return CountriesApplication.ourCountryList.findCountry(c-> (c.getId() == id));
    }

    @RequestMapping("/allcountries")
    public ArrayList<Country> getAllCountries()
    {
        CountriesApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));

        // sort countryList by name, alphabetically
        return CountriesApplication.ourCountryList.countryList;
    }
}
