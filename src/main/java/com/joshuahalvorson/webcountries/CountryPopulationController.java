package com.joshuahalvorson.webcountries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class CountryPopulationController {

    // /population/size?people=
    @RequestMapping("/size")
    public ArrayList<Country> getCountriesByPopulationGiven(@RequestParam(value = "people") String population){
        ArrayList<Country> countries = new ArrayList<>();
        try{
            WebcountriesApplication.countriesList.countryList.forEach(country -> {
                if(country.getPopulation() >= Integer.parseInt(population))
                    countries.add(country);
            });

        }catch (NumberFormatException e){
            e.getMessage();
        }


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

    // /population/max
    @RequestMapping("/max")
    public Country getLargestCountryByPopulation(){
        int lastPop = 0;
        Country lastCountry = null;

        for(Country c : WebcountriesApplication.countriesList.countryList){
            if(c.getPopulation() > lastPop){
                lastCountry = c;
                lastPop = c.getPopulation();
            }
        }

        return lastCountry;
    }
}
