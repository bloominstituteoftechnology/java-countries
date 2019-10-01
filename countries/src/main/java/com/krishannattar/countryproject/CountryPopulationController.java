package com.krishannattar.countryproject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class CountryPopulationController {



    @GetMapping(value = "/size/{people}",
            produces = "application/json")
    public ResponseEntity<?> getCountriesByNameLength(@PathVariable long people)
    {
        ArrayList<Country> returnCountries = CountryprojectApplication.ourCountryList.findCountries(c->c.getPopulation()>=people);
//        returnCountries.sort((c1,c2)->c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(returnCountries,HttpStatus.OK);
    }
}
