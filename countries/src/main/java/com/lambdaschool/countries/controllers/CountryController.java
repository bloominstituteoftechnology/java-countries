package com.lambdaschool.countries.controllers;

import java.util.ArrayList;
import java.util.List;

import com.lambdaschool.countries.models.*;
import com.lambdaschool.countries.repositories.CounrtryRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class CountryController {

    @Autowired
    CounrtryRepo counrtryRepo;

    private List<Country> findCountries(List<Country> list, CheckCountry tester){
        List<Country> tempList = new ArrayList<>();
        for (Country c : list){
            if(tester.test(c)){
                tempList.add(c);
            }
        }
        return tempList;
    }


    @GetMapping(value = "names/all", produces = "application/json")
    public ResponseEntity<?> countryNames(){
        List<Country> allCountries = new ArrayList<>();
        counrtryRepo.findAll().iterator().forEachRemaining(allCountries::add);
        allCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(allCountries, HttpStatus.OK);
    }

    @GetMapping(value = "names/start/{letter}", produces = "application/json")
    public ResponseEntity<?> countriesThatStartWith(@PathVariable char letter){
        List<Country> allCountries = new ArrayList<>();
        counrtryRepo.findAll().iterator().forEachRemaining(allCountries::add);

        List<Country> rtnList = findCountries(allCountries, c -> c.getName.charAt(0) == letter);

        rtnList.forEach(country -> System.out.println(country));
        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }

    @GetMapping(value = "population/total", produces = "application/json")
    public ResponseEntity<?> totalPop(){
        List<Country> myList = new ArrayList<>();
        counrtryRepo.findAll().iterator().forEachRemaining(myList::add);
        long total;
        myList.forEach(country -> total = total + country.getPopulation());

        return new ResponseEntity<>(total, HttpStatus.OK);
    }

    @GetMapping(value = "population/min", produces = "application/json")
    public ResponseEntity<?> minPop(){
        List<Country> myList = new ArrayList<>();
        counrtryRepo.findAll().iterator().forEachRemaining(myList::add);

        long minPopulation = 0;
        for(Country c : myList){
            if (c.getPopulation() < minPopulation){
                minPopulation = c.getPopulation();
            }
        }
        
        return new ResponseEntity<>(minPopulation, HttpStatus.OK);
    }

    @GetMapping(value = "population/max", produces = "application/json")
    public ResponseEntity<?> maxPop(){
        List<Country> myList = new ArrayList<>();
        counrtryRepo.findAll().iterator().forEachRemaining(myList::add);

        long maxPopulation = 0;
        for(Country c : myList){
            if (c.getPopulation() > maxPopulation){
                maxPopulation = c.getPopulation();
            }
        }
        
        return new ResponseEntity<>(maxPopulation, HttpStatus.OK);
    }

    
}