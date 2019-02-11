package com.joshuahalvorson.webcountries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/age")
public class CountryAgeController {

    // /age/age?age=
    @RequestMapping("/age")
    public ArrayList<Country> getCountriesWithMedianAgeEqualOrGreaterThanGiven(@RequestParam(value = "age") int age){
        ArrayList<Country> countries = new ArrayList<>();

        WebcountriesApplication.countriesList.countryList.forEach(country -> {
            if(country.getMedianAge() >= age){
                countries.add(country);
            }
        });

        return countries;
    }

}
