package com.example.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/age")
public class CountryAgeController {

    // localhost:8080/age/age/1
    // Countries with median age = to or > than provided age
    @GetMapping(value = "/age/{age}")
    public ResponseEntity<?> getCountriesAge(@PathVariable int age) {
        ArrayList<Country> rtnAge = JavacountriesApplication.myCountryList.findCountry(c -> c.getMedian_age() >= age);
        rtnAge.sort((c1, c2) -> c1.getCountry_name().compareToIgnoreCase(c2.getCountry_name()));
        return new ResponseEntity<>(rtnAge, HttpStatus.OK);
    }

    // localhost:8080/age/max
    // Country with largest median age
    @GetMapping(value = "/max")
    public Country getMaxAge() {
        int age = 0;
        Country country = null;

        for (Country c : JavacountriesApplication.myCountryList.countryList) {
            if (c.getMedian_age() > age) {
                age = c.getMedian_age();
                country = c;
            }
        }
        return country;
    }

    // localhost:8080/age/min
    // Country with smallest age
    @GetMapping(value = "/min")
    public Country getMinAge() {
        int min = 1000;
        Country minAge = null;
        for (Country c : JavacountriesApplication.myCountryList.countryList) {
            if (c.getMedian_age() <= min) {
                min = c.getMedian_age();
                minAge = c;
            }
        }
        return minAge;
    }
}
