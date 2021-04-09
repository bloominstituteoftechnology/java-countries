package lambda.school.javacountries.controllers;

import lambda.school.javacountries.model.Country;
import lambda.school.javacountries.repositories.CountryRepository;
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
  private CountryRepository countryRepository;
  
  @GetMapping(value = "/javacountries/all", produces = "application/json")
  public ResponseEntity<?> findAllCountries() {
    List<Country> countries = new ArrayList<>();
    countryRepository.findAll().iterator().forEachRemaining(e -> countries.add(e));
    return new ResponseEntity<>(countries, HttpStatus.OK);
  }
  
  // http://localhost:2019/countries/name/all
  @GetMapping(value = "/countries/name/all", produces = "application/json")
  public ResponseEntity<?> getNameAll() {
    List<Country> countryList = new ArrayList<>();
    countryRepository.findAll().iterator().forEachRemaining(e -> countryList.add(e));
    System.out.println(countryList);
    return new ResponseEntity<>(countryList, HttpStatus.OK);
  }
  
  // http://localhost:2019/countries/name/start/{letter}
  @GetMapping(value = "/countries/name/start/{letter}", produces = "application/json")
  public ResponseEntity<?> findByName(@PathVariable char letter) {
    List<Country> countryList = new ArrayList<>();
    countryRepository.findAll().iterator().forEachRemaining(countryList::add);
    List<Country> filteredList = filterCountries(countryList,
                                                  (e) ->e.getName().charAt(0) == letter);
    return new ResponseEntity<>(filteredList, HttpStatus.OK);
  }
  
  // http://localhost:2019/population/total
  @GetMapping(value = "/population/total", produces = "application/json")
  public ResponseEntity<?> getTotal() {
    List<Country> countryList = new ArrayList<>();
    countryRepository.findAll().iterator().forEachRemaining(e -> countryList.add(e));
    
    long total = 0;
    
    for (Country e : countryList) {
      total += e.getPopulation();
    }
    System.out.println("The total is: " + total);
    return new ResponseEntity<>(total, HttpStatus.OK);
  }
  
  // http://localhost:2019/population/min
  @GetMapping(value = "/population/min", produces = "application/json")
  public ResponseEntity<?> getMin() {
    List<Country> countryMin = new ArrayList<>();
    countryRepository.findAll().iterator().forEachRemaining(e -> countryMin.add(e));
    
    int size = countryMin.size();
    long min = countryMin.get(0).getPopulation();
    
    for (int i = 1; i < size; i++) {
      if (min > countryMin.get(i).getPopulation()) {
        min = countryMin.get(i).getPopulation();
      }
    }
    long finalMin = min;
    List<Country> filteredList = filterCountries(countryMin,
                                                 (e) ->e.getPopulation() == finalMin);
    
    System.out.println("The min is: " + min);
    return new ResponseEntity<>(filteredList, HttpStatus.OK);
  }
  
  // http://localhost:2019/population/max
  @GetMapping(value = "/population/max", produces = "application/json")
  public ResponseEntity<?> getMax() {
    List<Country> countryMax = new ArrayList<>();
    countryRepository.findAll().iterator().forEachRemaining(e -> countryMax.add(e));
    
    int size = countryMax.size();
    long max = countryMax.get(0).getPopulation();
    
    for (int i = 1; i < size; i++) {
      if (max < countryMax.get(i).getPopulation()) {
        max = countryMax.get(i).getPopulation();
      }
    }
    long finalMax = max;
    List<Country> filteredList = filterCountries(countryMax,
                                                 (e) ->e.getPopulation() == finalMax);
    
    System.out.println("The max is: " + max);
    return new ResponseEntity<>(filteredList, HttpStatus.OK);
  }
  
  //STRETCH
  // http://localhost:2019/population/median
  @GetMapping(value = "/population/median", produces = "application/json")
  public ResponseEntity<?> getMedian() {
    List<Country> countryList = new ArrayList<>();
    countryRepository.findAll().iterator().forEachRemaining(e -> countryList.add(e));
    
    int size = countryList.size();
    long num = 0;
    
    
    Comparator<Country> sortedList = Comparator.comparingLong(Country::getPopulation);
    Collections.sort(countryList, sortedList);
//    Check if list is sorted
    for (Country obj : countryList) {
      System.out.println(obj.getPopulation());
    }
    
    //Confirm mid population size
    long middle = countryList.get(size / 2).getPopulation();
    System.out.println("Middle population is :" + middle);
    
    if (size % 2 == 1) {
      num = (countryList.get((size / 2) + 1).getPopulation());
    }
    else {
      num = countryList.get(size / 2).getPopulation();
    }
    long finalMedian = num;
    List<Country> filteredList = filterCountries(countryList,
                                                 (e) ->e.getPopulation() == finalMedian);
    
    System.out.println("The median is: " + num);
    return new ResponseEntity<>(filteredList, HttpStatus.OK);
  }
  private List<Country> filterCountries(List<Country> countryList, QueryCountries tester) {
    List<Country> newFilteredList = new ArrayList<>();
  
    for (Country e : countryList) {
      if (tester.test(e)) {
        newFilteredList.add(e);
      }
    }
    return newFilteredList;
  }
}
