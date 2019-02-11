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
    public ArrayList<Country> getCountriesWithMedianAgeEqualOrGreaterThanGiven(@RequestParam(value = "age") String age){
        ArrayList<Country> countries = new ArrayList<>();

        try {
            WebcountriesApplication.countriesList.countryList.forEach(country -> {
                if((country.getMedianAge() >= Integer.parseInt(age))){
                    countries.add(country);
                }
            });
        }catch (NumberFormatException e){
            e.getMessage();
        }


        return countries;
    }

    // /age/min
    @RequestMapping("/min")
    public Country getCountryWithLowestMedianAge(){
        int lastAge = 0;
        Country lastCountry = null;

        for(Country c : WebcountriesApplication.countriesList.countryList){
            if(c.getMedianAge() > lastAge){
                lastAge = c.getMedianAge();
            }else{
                lastCountry = c;
            }
        }

        return lastCountry;
    }

    // /age/max
    @RequestMapping("/max")
    public Country getCountryWithHighestMedianAge(){
        int lastAge = 0;
        Country lastCountry = null;

        for(Country c : WebcountriesApplication.countriesList.countryList){
            if(c.getMedianAge() > lastAge){
                lastCountry = c;
                lastAge = c.getMedianAge();
            }
        }

        return lastCountry;
    }
}
