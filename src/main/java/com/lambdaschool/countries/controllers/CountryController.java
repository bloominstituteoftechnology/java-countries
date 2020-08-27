package com.lambdaschool.countries.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.lambdaschool.countries.models.Country;
import com.lambdaschool.countries.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
public class CountryController {
    @Autowired
    CountryRepository countryRepository;

    private List<Country> findCountries(List<Country> countryList, CheckCountry tester){
        List<Country> tempList = new ArrayList<>();

        for (Country e : countryList){
            if (tester.test(e)){
                tempList.add(e);
            }
        }
        return tempList;
    }

    //http://localhost:2019/names/all
    @GetMapping(value = "/names/all", produces = {"application/json"})
    public ResponseEntity<?> ListAllCountries(){
        List<Country> countryList = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining(countryList::add);
        countryList.sort((v1,v2) -> v1.getName().compareToIgnoreCase(v2.getName()));
        return new ResponseEntity<>(countryList, HttpStatus.OK);
    }
    //http://localhost:2019/names/start/{letter}
    @GetMapping(value = "/names/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> ListAllByName(@PathVariable char letter){
        List<Country> countryList = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining(countryList::add);
        List<Country> rtnList = findCountries(countryList, e -> e.getName().charAt(0) == letter);
        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }
    //http://localhost:2019/population/total
    @GetMapping(value = "/population/total", produces = {"application/json"})
    public ResponseEntity<?> TotalPopulation(){
        List<Country> countryList = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining(countryList::add);

        long totalPopulation = 0;
        for (Country c : countryList){
            totalPopulation = totalPopulation + c.getPopulation();
        }
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode total = mapper.createObjectNode();
        total.put("population_total", totalPopulation);

        return new ResponseEntity<>(total, HttpStatus.OK);
    }
    //http://localhost:2019/population/min
    @GetMapping(value = "population/min", produces = {"application/json"})
    public ResponseEntity<?> MinPopulation(){
        List<Country> countryList = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining(countryList::add);
        countryList.sort(Comparator.comparing(Country::getPopulation));

        return new ResponseEntity<>(countryList.get(0), HttpStatus.OK);
    }
    //http://localhost:2019/population/max
    @GetMapping(value = "population/max", produces = {"application/json"})
    public ResponseEntity<?> MaxPopulation(){
        List<Country> countryList = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining(countryList::add);
        countryList.sort(Comparator.comparing(Country::getPopulation).reversed());

        return new ResponseEntity<>(countryList.get(0), HttpStatus.OK);
    }


}
