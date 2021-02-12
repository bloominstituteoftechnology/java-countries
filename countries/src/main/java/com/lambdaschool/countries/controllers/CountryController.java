package com.lambdaschool.countries.controllers;

import com.lambdaschool.countries.models.Country;
import com.lambdaschool.countries.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController {

  private static List<Country> findCountries(List<Country> myList, CheckCountry tester) {
    List<Country> tempList = new ArrayList<>();
    for (Country c : myList) {
      if (tester.test(c)) {
        tempList.add(c);
      }
    }
    return tempList;
  }

  @Autowired
  CountryRepository countryRepository;

  // http://localhost:2019/names/all
  @GetMapping(value = "/names/all", produces = {"application/json"})
  public ResponseEntity<?> listAllCountry() {
    List<Country> myList = new ArrayList<>();
    countryRepository.findAll().iterator().forEachRemaining(myList::add);

    myList.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));

    return new ResponseEntity<>(myList, HttpStatus.OK);
  }

  //http://localhost:2019/names/start/{letter}
  @GetMapping(value = "/names/start/{letter}", produces = {"application/json"})
  public ResponseEntity<?> listCountryName(@PathVariable char letter) {
    List<Country> myList = new ArrayList<>();
    countryRepository.findAll().iterator().forEachRemaining(myList::add);

    List<Country> rtnList = findCountries(myList, c -> c.getName().charAt(0) == letter);

    return new ResponseEntity<>(rtnList, HttpStatus.OK);
  }

  //http://localhost:2019/population/total
  @GetMapping(value = "/population/total", produces = {"application/json"})
  public ResponseEntity<?> listPopulationTotal() {
    List<Country> myList = new ArrayList<>();
    countryRepository.findAll().iterator().forEachRemaining(myList::add);
    long total = 0;
    for (Country c : myList) {
      total += c.getPopulation();
    }
    String response = "Population total is: " + total;

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  //http://localhost:2019/population/min
  @GetMapping(value = "/population/min", produces = {"application/json"})
  public ResponseEntity<?> listPopulationMin() {
    List<Country> myList = new ArrayList<>();
    countryRepository.findAll().iterator().forEachRemaining(myList::add);
    myList.sort((c1, c2) -> (int) (c1.getPopulation() - c2.getPopulation()));

    Country popMin = myList.get(0);

    return new ResponseEntity<>(popMin, HttpStatus.OK);
  }

  //http://localhost:2019/population/max
  @GetMapping(value = "/population/max", produces = {"application/json"})
  public ResponseEntity<?> listPopulationMax() {
    List<Country> myList = new ArrayList<>();
    countryRepository.findAll().iterator().forEachRemaining(myList::add);
    myList.sort((c1, c2) -> (int) (c2.getPopulation() - c1.getPopulation()));

    Country popMax = myList.get(0);

    return new ResponseEntity<>(popMax, HttpStatus.OK);
  }
}
