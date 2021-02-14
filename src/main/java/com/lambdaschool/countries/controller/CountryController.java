package com.lambdaschool.countries.controller;


import com.lambdaschool.countries.models.Country;
import com.lambdaschool.countries.repositories.CountryRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController
{

    @Autowired
    private CountryRepositories countriesRepo;

    private List<Country> filterCountries(List<Country> myCountries, CountryChecker myChecker)
    {
        List<Country> tempList = new ArrayList<>();
        for (Country c : myCountries ) {
            if (myChecker.checker(c)) {
                tempList.add(c);
            }
        }
        return tempList;
    }


    // http://localhost:2019/names/all
    @GetMapping(value = "/names/all", produces = {"application/json"})
    public ResponseEntity<?> getAllCountries()
    {
        List<Country> allCountries = new ArrayList<>();

        countriesRepo.findAll().iterator().forEachRemaining(allCountries::add);

        return new ResponseEntity<>(allCountries, HttpStatus.OK);
    }


    //http://localhost:2019/names/start/u
    @GetMapping(value = "/names/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> getNameWithCertainLetter(@PathVariable char letter)
    {
        List<Country> allCountries = new ArrayList<>();

        countriesRepo.findAll().iterator().forEachRemaining(allCountries::add);

        List<Country> FilteredList = filterCountries(allCountries, v -> Character.toUpperCase(v.getName().charAt(0)) == Character.toUpperCase(letter));

        return new ResponseEntity<>(FilteredList, HttpStatus.OK);
    }


    //http://localhost:2019/population/total
    @GetMapping(value = "population/total", produces = {"application/json"})
    public ResponseEntity<?> getPopulationTotal()
    {
        List<Country> allCountries = new ArrayList<>();

        countriesRepo.findAll().iterator().forEachRemaining(allCountries::add);

        long totalPopulation = 0;
        for (Country c : allCountries)
        {
            totalPopulation += c.getPopulation();
        }

        System.out.println(totalPopulation);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //http://localhost:2019/population/min
    @GetMapping(value = "/population/min", produces = {"application/json"})
    public ResponseEntity<?> getMinPopulation()
    {
        List<Country> allCountries = new ArrayList<>();

        countriesRepo.findAll().iterator().forEachRemaining(allCountries::add);
        Country smallestPopulation = allCountries.get(0);
        for (Country c : allCountries)
        {
            if (c.getPopulation() < smallestPopulation.getPopulation())
            {
                smallestPopulation = c;
            }
        }

        return new ResponseEntity<>(smallestPopulation, HttpStatus.OK);
    }


    // http://localhost:2019/population/max
    @GetMapping(value = "/population/max", produces = {"application/json"})
    public ResponseEntity<?> getMaxPopulation()
    {
        List<Country> myCountries = new ArrayList<>();

        countriesRepo.findAll().iterator().forEachRemaining(myCountries::add);

        Country maxPopulation = myCountries.get(0);
        for (Country c : myCountries)
        {
            if (c.getPopulation() > maxPopulation.getPopulation())
            {
                maxPopulation = c;
            }
        }

        return new ResponseEntity<>(maxPopulation, HttpStatus.OK);
    }


    //http://localhost:2019/population/median
    @GetMapping(value = "/population/median", produces = {"application/json"})
    public ResponseEntity<?> getMedianPopulation()
    {
        List<Country> myCountries = new ArrayList<>();

        countriesRepo.findAll().iterator().forEachRemaining(myCountries::add);
        myCountries.sort((v1,v2) -> (int)(v1.getPopulation() - v2.getPopulation()));

        int lengthOfList = 0;

        for (Country c : myCountries)
        {
            lengthOfList += 1;
        }

        int middle = lengthOfList / 2;
        if (lengthOfList%2 == 1)
        {
            middle += 1;
        }

        return new ResponseEntity<>(myCountries.get(middle), HttpStatus.OK);
    }
}
