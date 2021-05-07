package com.example.countriesflex.controllers;


import com.example.countriesflex.models.Country;
import com.example.countriesflex.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {
@Autowired
    CountryService countryService;

    @GetMapping(value = "/names/all", produces = "application/json")
    public ResponseEntity<?> listAllCountries()
    {
        List<Country> returnList = countryService.getAllCountries();
        return new ResponseEntity<>(returnList, HttpStatus.OK);
    }

    @GetMapping(value = "/population/total", produces = "application/json")
    public ResponseEntity<?> listTotalPopulation()
    {

        long returnTotalPop = countryService.getPopulationTotal();
        System.out.println("The Total Population is " + returnTotalPop);
        return new ResponseEntity<>(HttpStatus.OK);



    }

    @GetMapping(value = "/")

}
