package com.lambdaschool.countries.controller;


import com.lambdaschool.countries.models.Country;
import com.lambdaschool.countries.repositories.CountriesRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountriesController {


    @Autowired
    private CountriesRepositories countriesRepo;

    // http://localhost:2019/names/all
    @GetMapping(value = "/names/all", produces={"applciation/json"})
    public ResponseEntity<?> getAllCountries()
    {
        List<Country> allCountries = new ArrayList<>();

        countriesRepo.findAll().iterator().forEachRemaining(allCountries::add);

        return new ResponseEntity<>(allCountries, HttpStatus.OK);

    }


    //http://localhost:2019/names/start/u



    //http://localhost:2019/population/total




    //http://localhost:2019/population/min




    // http://localhost:2019/population/max




    //http://localhost:2019/population/median
}
