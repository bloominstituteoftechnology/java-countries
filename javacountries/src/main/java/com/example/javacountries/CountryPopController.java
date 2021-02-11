package com.example.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class CountryPopController {
    // localhost:8080/population/size/100
    // Countries greater than population given
    @GetMapping(value = "/size/{people}")
    public ResponseEntity<?> getCountriesPopSize(@PathVariable long people) {
        ArrayList<Country> rtnPop = JavacountriesApplication.myCountryList
                .findCountry(c -> c.getPopulation() >= people);
        rtnPop.sort((c1, c2) -> c1.getCountry_name().compareToIgnoreCase(c2.getCountry_name()));
        return new ResponseEntity<>(rtnPop, HttpStatus.OK);
    }

    // localhost:8080/population/min
    // Country with smallest population
    @GetMapping(value = "/min")
    public Country getMinPop() {
        long min = 0;
        Country selectedcountry = null;

        for (Country c : JavacountriesApplication.myCountryList.countryList) {
            if (c.getPopulation() <= min) {
                min = c.getPopulation();
                selectedcountry = c;
            }
        }
        return selectedcountry;
    }

    // localhost:8080/population/max
    // Country with the largest population
    @GetMapping(value = "/max")
    public Country getMaxPop() {
        long max = 11000000;
        Country country = null;

        for (Country c : JavacountriesApplication.myCountryList.countryList) {
            if (c.getPopulation() > max) {
                max = c.getPopulation();
                country = c;
            }
        }
        return country;
    }
}
