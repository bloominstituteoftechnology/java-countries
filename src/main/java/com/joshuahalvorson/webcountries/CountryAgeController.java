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

    // /population/min
    @RequestMapping("/min")
    public Country getSmallestCountryByPopulation(){
        int lastPop = 0;
        Country lastCountry = null;

        for(Country c : WebcountriesApplication.countriesList.countryList){
            if(c.getPopulation() > lastPop){
                lastPop = c.getPopulation();
            }else{
                lastCountry = c;
            }
        }
        
        return lastCountry;
    }
}
