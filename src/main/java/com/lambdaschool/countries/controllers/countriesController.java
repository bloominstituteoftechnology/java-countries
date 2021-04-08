package com.lambdaschool.countries.controllers;

import com.lambdaschool.countries.models.countries;
import com.lambdaschool.countries.repositories.countriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class countriesController {
    @Autowired
    private countriesRepository countriesRepo;

    // http://localhost:2019/names/all
    @GetMapping(value = "/names/all", produces = "application/json")
    public ResponseEntity<?> findAllCountries() {
        List<countries> countriesList = new ArrayList<>();
        countriesRepo.findAll().iterator().forEachRemaining(countriesList::add);

        return new ResponseEntity<>(countriesList, HttpStatus.OK);
    }


    // http://localhost:2019/names/start/{letter}
    @GetMapping(value = "/names/start/{letter}", produces = "application/json")
    public ResponseEntity<?> findByLetter(@PathVariable char letter){
        List<countries> countriesList = new ArrayList<>();
        countriesRepo.findAll().iterator().forEachRemaining(countriesList::add);

        List<countries> filteredCountriesList = filterCountries(countriesList, (country)->Character.toLowerCase(country.getName().charAt(0)) == Character.toLowerCase(letter));

        return new ResponseEntity<>(filteredCountriesList, HttpStatus.OK);
    }

    private List<countries> filterCountries(List<countries> countriesList, checkCountries tester){
        List<countries> theReturnList = new ArrayList<>();

        for (countries country : countriesList) {
            if (tester.test(country)) {
                theReturnList.add(country);
            }
        }
        return theReturnList;
    }


    // http://localhost:2019/population/total
    @GetMapping(value = "/population/total", produces = "application/json")
    public ResponseEntity<?> findTotal() {
        List<countries> countriesList = new ArrayList<>();
        countriesRepo.findAll().iterator().forEachRemaining(countriesList::add);
        long totalReturn = 0;

        for (countries country:countriesList) {
            totalReturn += country.getPoulation();
        }

        String fullReturn = "The Total Population is: " + totalReturn;
        System.out.println(fullReturn);
        return new ResponseEntity<>(totalReturn, HttpStatus.OK);
    }


    // http://localhost:2019/population/min
    @GetMapping(value = "/population/min", produces = "application/json")
    public ResponseEntity<?> findMin() {
        List<countries> countriesList = new ArrayList<>();
        countriesRepo.findAll().iterator().forEachRemaining(countriesList::add);
        long runningMin = 2000000000;
        countries currentMin = new countries();

        for (countries country:countriesList) {
            if(runningMin > country.getPoulation()){
                runningMin = country.getPoulation();
                currentMin = country;
            }
        }

        return new ResponseEntity<>(currentMin, HttpStatus.OK);
    }


    // http://localhost:2019/population/max
    @GetMapping(value = "/population/max", produces = "application/json")
    public ResponseEntity<?> findMax() {
        List<countries> countriesList = new ArrayList<>();
        countriesRepo.findAll().iterator().forEachRemaining(countriesList::add);
        long runningMax = 0;
        countries currentMax = new countries();

        for (countries country:countriesList) {
            if(runningMax < country.getPoulation()){
                runningMax = country.getPoulation();
                currentMax = country;
            }
        }

        return new ResponseEntity<>(currentMax, HttpStatus.OK);
    }
}
