package com.lambdaschool.countrysearch;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class CountryPopulationController
{

//    localhost:5000/population/size/{people}
//    return the countries that have a population equal to or greater than the given population
    @GetMapping(value = "/size/{people}",
                produces = {"application/json"})
    public ResponseEntity<?> getPopEqualGreaterThanGivenPop(
            @PathVariable Long people)
    {
        ArrayList<Country> countries = CountrysearchApplication.ourCountryList
                .findCountries(c -> c.getPopulation() >= people);
        countries.sort ((c1, c2) -> c1.getCountryName().compareToIgnoreCase(c2.getCountryName()));
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

//    localhost:5000/population/min
//    return the country with the smallest population

    @GetMapping(value = "/min",
            produces = {"application/json"})
    public ResponseEntity<?> getMin()
    {
        long min = 1000000000;
        Country country  = null;

        for (Country c : CountrysearchApplication.ourCountryList.countryList)
        {
            if(c.getPopulation() <= min)
            {
                min = c.getPopulation();
                country = c;
            }
        }
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

//    localhost:5000/population/max
//    return the country with the largest population

    @GetMapping(value = "/max",
            produces = {"application/json"})
    public ResponseEntity<?> getMax()
    {
        long max = 0;
        Country thisCountry  = null;

        for (Country c : CountrysearchApplication.ourCountryList.countryList)
        {
            if(c.getPopulation() > max)
            {
                max = c.getPopulation();
                thisCountry = c;
            }
        }
        return new ResponseEntity<>(thisCountry, HttpStatus.OK);
    }


//    Stretch Goal
//    localhost:5000/population/median
//    return the country with the median population


}
