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
