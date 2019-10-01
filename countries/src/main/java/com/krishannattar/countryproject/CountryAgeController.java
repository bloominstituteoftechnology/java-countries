package com.krishannattar.countryproject;


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

    @GetMapping(value = "/age/{age}",
    produces = "application/json")
    public ResponseEntity<?> getCountriesByMedianAge(@PathVariable int age)
    {
        ArrayList<Country> returnCountries = new ArrayList<>();
        returnCountries = CountryprojectApplication.ourCountryList.findCountries(c->c.getMedianAge() >= age);
        returnCountries.sort((c1,c2)->c2.getMedianAge()-c1.getMedianAge());
        return new ResponseEntity<>(returnCountries, HttpStatus.OK);
    }
}
