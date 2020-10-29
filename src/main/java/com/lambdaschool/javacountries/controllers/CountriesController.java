package com.lambdaschool.javacountries.controllers;


import com.lambdaschool.javacountries.models.Countries;
import com.lambdaschool.javacountries.repositories.CountriesRepository;
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
    CountriesRepository countriesRepository;

    private List<Countries> filterCountries(List<Countries> myList, CheckCountries tester) {
        List<Countries> testList = new ArrayList<>();

        for (Countries c: myList) {
            if (tester.test(c)) {
                testList.add(c);
            }
        }
        return testList;
    }


    //http://localhost:2019/names/all
    @GetMapping(value = "/names/all", produces = "application/json")
    public ResponseEntity<?> listAllCountries() {
        List<Countries> myList = new ArrayList<>();
        countriesRepository.findAll().iterator().forEachRemaining(myList::add);

        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    //http://localhost:2019/names/start/u
    @GetMapping(value = "/names/start/{U}", produces = "application/json")
    public ResponseEntity<?> listUCountries(@PathVariable char U) {
        List<Countries> myList = new ArrayList<>();
        countriesRepository.findAll().iterator().forEachRemaining(myList::add);

        List<Countries> newList = filterCountries(myList, c -> c.getName().charAt(0) == U );

        return new ResponseEntity<>(newList, HttpStatus.OK);
    }

    //http://localhost:2019/population/total
    @GetMapping(value = "/population/total", produces = "application/json")
    public ResponseEntity<?> populationTotal() {
        List<Countries> myList = new ArrayList<>();
        countriesRepository.findAll().iterator().forEachRemaining(myList::add);

        int total = 0;
        for (Countries c : myList) {
            total += c.getPopulation();
        }

        return new ResponseEntity<>(total, HttpStatus.OK);
    }


    //http://localhost:2019/population/min
    @GetMapping(value = "population/min", produces = "application/json")
    public ResponseEntity<?> populationMin() {
        List<Countries> myList = new ArrayList<>();
        countriesRepository.findAll().iterator().forEachRemaining(myList::add);

//        int min = 0;
//        for (Countries c: myList){
//            getMinValue(c.getPopulation());
//        }

        return new ResponseEntity<>()
    }


    //http://localhost:2019/population/max
    @GetMapping(value = "population/max", produces = "application/json")
    public ResponseEntity<?> populationMax() {
        List<Countries> myList = new ArrayList<>();
        countriesRepository.findAll().iterator().forEachRemaining(myList::add);

        return new ResponseEntity<>()
    }
}
