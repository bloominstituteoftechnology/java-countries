package com.lambdaschool.countryapp.controllers;

import com.lambdaschool.countryapp.models.Country;
import com.lambdaschool.countryapp.repositories.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController
{
    @Autowired
    CountryRepo countryRepo;

    // http://localhost:2019/countries/all
    @GetMapping(value = "/countries/all", produces = {"application/json"})
    public ResponseEntity<?> listAllCountry()
    {
        List<Country> myList = new ArrayList<>();
        countryRepo.findAll().iterator().forEachRemaining(myList::add);
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }
}
