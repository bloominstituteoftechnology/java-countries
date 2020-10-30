package com.lambdaschool.com.countries.controllers;

import com.lambdaschool.com.countries.CountriesApplication;
import com.lambdaschool.com.countries.models.CountryInfo;
import com.lambdaschool.com.countries.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController
{

    @Autowired
    Repository countryrepos;

    @GetMapping(value = "/population/total",
        produces = {"application/json"})
    public ResponseEntity<?> findLargerPopulations()
    {
        List<CountryInfo> myList = new ArrayList<>();
        countryrepos.findAll().iterator().forEachRemaining(myList::add);

        long total = 0;

        for (CountryInfo c : myList)
        {
            total = total + c.getPopulation();
        }

        System.out.println("The Total Population is " + total);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/population/min",
        produces = {"application/json"})
    public ResponseEntity<?> findMinPopulation()
    {
        List<CountryInfo> myList = new ArrayList<>();
        countryrepos.findAll().iterator().forEachRemaining(myList::add);

        myList.sort((c1, c2) -> (int) (c1.getPopulation() - c2.getPopulation()));

        Country rtnCountry = myList.get(0);
        return new ResponseEntity<>(rtnCountry,
            HttpStatus.OK);
    }


    @GetMapping(value = "/population/max",
        produces = {"application/json"})
    public ResponseEntity<?> findMaxPopulation()
    {
        List<CountryInfo> myList = new ArrayList<>();
        countryrepos.findAll().iterator().forEachRemaining(myList::add);

        myList.sort((c1, c2) -> (int) (c2.getPopulation() - c1.getPopulation()));

        CountryInfo rtnCountry = myList.get(0);
        return new ResponseEntity<>(rtnCountry,
            HttpStatus.OK);
    }

    @GetMapping(value = "/population/median",
        produces = {"application/json"})
    public ResponseEntity<?> findMedianPopulation()
    {
        List<CountryInfo> myList = new ArrayList<>();
        countryrepos.findAll().iterator().forEachRemaining(myList::add);

        myList.sort((c1, c2) -> (int) (c1.getPopulation() - c2.getPopulation()));

        CountryInfo rtnCountry = myList.get((myList.size() / 2) + 1);
        return new ResponseEntity<>(rtnCountry,
            HttpStatus.OK);
    }

    @GetMapping(value = "/names/all",
        produces = {"application/json"})
    public ResponseEntity<?> getAllCountries()
    {
        List<CountryInfo> myList = new ArrayList<>();
        countryrepos.findAll().iterator().forEachRemaining(myList::add);

        myList.sort((c1, c2) -> c1.getName()
            .compareToIgnoreCase(c2.getName()));

        return new ResponseEntity<>(myList,
            HttpStatus.OK);
    }

    @GetMapping(value = "/names/start/{letter}",
        produces = {"application/json"})
    public ResponseEntity<?> getCountriesWithStartLetter(
        @PathVariable
            char letter)
    {
        List<CountryInfo> myList = new ArrayList<>();
        countryrepos.findAll().iterator().forEachRemaining(myList::add);

        List<CountryInfo> rtnList = ExtraFunctions.findCountries(myList, c -> c.getName()
            .toUpperCase()
            .charAt(0) == Character.toUpperCase(letter));

        rtnList.sort((c1, c2) -> c1.getName()
            .compareToIgnoreCase(c2.getName()));

        return new ResponseEntity<>(rtnList,
            HttpStatus.OK);
    }
}
