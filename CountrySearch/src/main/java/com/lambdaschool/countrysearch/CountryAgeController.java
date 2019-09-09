package com.lambdaschool.countrysearch;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/age")
public class CountryAgeController
{

//    localhost:5000/age/age/{age}
//    return the countries that have a median age equal to or greater than the given age

    @GetMapping(value = "/age/{age}",
               produces = {"application/json"})
    public ResponseEntity<?> getCountriesByAge(
            @PathVariable int age)
    {
        ArrayList<Country> countries = CountrysearchApplication.ourCountryList
                .findCountries(c -> c.getMedianAge() >= age);
        countries.sort((c1, c2) -> c1.getCountryName().compareToIgnoreCase(c2.getCountryName()));
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }


//    localhost:5000/age/min
//    return the country with the smallest median age

    @GetMapping(value = "/min",
            produces = {"application/json"})
    public ResponseEntity<?> getMinMedianAge()
    {
        long min = 1000;
        Country country  = null;

        for (Country c : CountrysearchApplication.ourCountryList.countryList)
        {
            if(c.getMedianAge() <= min)
            {
                min = c.getMedianAge();
                country = c;
            }
        }
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

//    localhost:5000/age/max
//    return the country the the greatest median age

    @GetMapping(value = "/max",
            produces = {"application/json"})
    public ResponseEntity<?> getMaxMedianAge()
    {
        long age = 0;
        Country thisCountry  = null;

        for (Country c : CountrysearchApplication.ourCountryList.countryList)
        {
            if(c.getMedianAge() > age)
            {
                age = c.getMedianAge();
                thisCountry = c;
            }
        }
        return new ResponseEntity<>(thisCountry, HttpStatus.OK);
    }

//    Stretch Goal
//    localhost:5000/age/median
//    return the country with the median median age

}
