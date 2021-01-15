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
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

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

    // http://localhost:2019/names/start/{letter}
    @GetMapping(value = "/names/start/{letter}", produces = "application/json")
    public ResponseEntity<?> findByName(@PathVariable char letter) {
        List<Country> myList = new ArrayList<>();

        char UpperCaseLetter = Character.toUpperCase(letter);

        countriesRepository.findAll().iterator().forEachRemaining(myList::add);

        List<Country> filteredList = filterCountries(myList, (c) -> c.getName().charAt(0) == UpperCaseLetter);

        return new ResponseEntity<>(filteredList, HttpStatus.OK);

    }

    // http://localhost:2019/population/total
    @GetMapping(value = "/population/total", produces = "application/json")
    public  ResponseEntity<?> findTotalPopulation() {
        List<Country> myList = new ArrayList<>();

        countriesRepository.findAll().iterator().forEachRemaining(myList::add);

        long totalPopulation = 0;
        for (Country c : myList) {
            totalPopulation += c.getPopulation();
        }

        System.out.println("The Total Population is " + totalPopulation);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //http://localhost:2019/population/min
    @GetMapping(value = "/population/min", produces = "application/json")
    public ResponseEntity<?> findByMinPopulation() {
        List<Country> myList = new ArrayList<>();


        countriesRepository.findAll().iterator().forEachRemaining(myList::add);

        Country minByPopulation = myList.stream().min(Comparator.comparing(Country::getPopulation)).orElseThrow(NoSuchElementException::new);

        return new ResponseEntity<>(minByPopulation, HttpStatus.OK);

    }

    //http://localhost:2019/population/max
    @GetMapping(value = "/population/max", produces = "application/json")
    public ResponseEntity<?> findByMaxPopulation() {
        List<Country> myList = new ArrayList<>();

        countriesRepository.findAll().iterator().forEachRemaining(myList::add);

        Country minByPopulation = myList.stream().max(Comparator.comparing(Country::getPopulation)).orElseThrow(NoSuchElementException::new);

        return new ResponseEntity<>(minByPopulation, HttpStatus.OK);

    }

    //http://localhost:2019/population/median
    @GetMapping(value = "/population/median", produces = "application/json")
    public ResponseEntity<?> findByMedianPopulation() {
        List<Country> myList = new ArrayList<>();


        countriesRepository.findAll().iterator().forEachRemaining(myList::add);

        myList.sort((firstItem, secondItem) -> ((int)firstItem.getPopulation() > (int)secondItem.getPopulation()) ? -1 : 1);

        int size = myList.size();

        Country median = myList.get((int)(-1 + size/2));

        return new ResponseEntity<>(median, HttpStatus.OK);

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
