package com.lambadaschool.countries.controllers;

import com.lambadaschool.countries.CheckCountry;
import com.lambadaschool.countries.models.Country;
import com.lambadaschool.countries.repositories.CountriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(value = "/names/start/{letter}", produces = "application/json")
    public ResponseEntity<?> findByName(@PathVariable char letter) {
        List<Country> myList = new ArrayList<>();

        char UpperCaseLetter = Character.toUpperCase(letter);

        countriesRepository.findAll().iterator().forEachRemaining(myList::add);

        List<Country> filteredList = filterCountries(myList, (c) -> c.getName().charAt(0) == UpperCaseLetter);

        return new ResponseEntity<>(filteredList, HttpStatus.OK);

    }

    private List<Country> filterCountries(List<Country> countriesList, CheckCountry tester) {
        List<Country> rtnList = new ArrayList<>();

        for (Country c : countriesList) {
            if (tester.test(c)) {
                rtnList.add(c);
            }
        }

        return  rtnList;
    }
}
