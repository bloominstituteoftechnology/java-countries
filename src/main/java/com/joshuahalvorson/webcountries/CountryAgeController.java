package com.joshuahalvorson.webcountries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class CountryAgeController {

    // /population/size?people=
    @RequestMapping("/size")
    public ArrayList<Country> getCountriesByPopulationGiven(@RequestParam(value = "people") int population){
        ArrayList<Country> countries = new ArrayList<>();

        WebcountriesApplication.countriesList.countryList.forEach(country -> {
            if(country.getPopulation() >= population)
                countries.add(country);
        });

        return countries;
    }
}
