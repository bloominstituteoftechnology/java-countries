package com.countries.countrysearch.controllers;

import com.countries.countrysearch.models.Country;
import com.countries.countrysearch.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController
{
    // create an object of the repository when we first run the class
    @Autowired
    CountryRepository cntryrepos;

    private List<Country> findCountries(List<Country> countryList, CheckCountry tester)
    {
        List<Country> theCountryList = new ArrayList<>();
        for(Country c : countryList)
        {
            if(tester.test(c))
            {
                theCountryList.add(c);
            }
        }
        return theCountryList;
    }
    //creating the endpoint
    //http://localhost:2019/names/all
    @GetMapping(value = "/names/all", produces = "application/json")
    public ResponseEntity<?> listAllCountries()
    {
        List<Country> myList = new ArrayList<>();
        cntryrepos.findAll().iterator().forEachRemaining(myList::add);
        myList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    //http://localhost:2019/names/start/u
    @GetMapping(value="/name/start/{letter}", produces = "application/json")
    public ResponseEntity<?> listAllCountriesByStartLetter(@PathVariable char letter)
    {
        List<Country> myList = new ArrayList<>();
        cntryrepos.findAll().iterator().forEachRemaining(myList::add);
        List<Country> returnList = findCountries(myList, c -> c.getName().charAt(0) == letter);
        return new ResponseEntity<>(returnList, HttpStatus.OK);
    }

    //http://localhost:2019/population/total
    @GetMapping(value ="/population/total", produces = "application/jason")
    public ResponseEntity<?> findLargePopulations()
    {
        List<Country> myList = new ArrayList<>();
        cntryrepos.findAll().iterator().forEachRemaining(myList::add);
        long total = 0;
        for (Country c : myList)
        {
            total = total + c.getPopulation();
        }

        System.out.println("The total population is " + total);

        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    //http://localhost:2019/population/min
    @GetMapping(value = "/population/min", produces = "application/json")
    public ResponseEntity<?> findMinimumPopulation()
    {
        List<Country> myList = new ArrayList<>();
        cntryrepos.findAll().iterator().forEachRemaining(myList::add);
        myList.sort((c1,c2) ->(int) (c1.getPopulation() - c2.getPopulation()));

        Country returnCountry = myList.get(0);
        return new ResponseEntity<>(returnCountry, HttpStatus.OK);
    }

    //http://localhost:2019/population/max
    @GetMapping(value = "/population/max", produces = "application/json")
    public ResponseEntity<?> findMaximumPopulation()
    {
        List<Country> myList = new ArrayList<>();
        cntryrepos.findAll().iterator().forEachRemaining(myList::add);
        myList.sort((c1,c2) ->(int) (c2.getPopulation() - c1.getPopulation()));

        Country returnCountry = myList.get(0);
        return new ResponseEntity<>(returnCountry, HttpStatus.OK);
    }

    //http://localhost:2019/population/median
    @GetMapping(value = "/population/median", produces = "application/json")
    public ResponseEntity<?> findMedianPopulation()
    {
        List<Country> myList = new ArrayList<>();
        cntryrepos.findAll().iterator().forEachRemaining(myList::add);
        myList.sort((c1,c2) ->(int) (c1.getPopulation() - c2.getPopulation()));

        Country returnCountry = myList.get((myList.size() / 2) +1 );
        return new ResponseEntity<>(returnCountry, HttpStatus.OK);
    }

}

