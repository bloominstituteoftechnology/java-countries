package com.lambadaschool.countries.controllers;

import com.lambadaschool.countries.models.Country;
import com.lambadaschool.countries.repositories.CountriesRepository;
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
    private CountriesRepository countriesRepository;

    // http://localhost:2019/names/all
    @GetMapping(value="/names/all", produces = "application/json")
    public ResponseEntity<?> listAllCountries() {
        List<Country> myList = new ArrayList<>();

        countriesRepository.findAll().iterator().forEachRemaining(myList::add);

        myList.sort((firstItem, secondItem) -> (firstItem.getName().charAt(0) > secondItem.getName().charAt(0)) ? 1 : -1);

        return new ResponseEntity<>(myList, HttpStatus.OK);
    }
}
