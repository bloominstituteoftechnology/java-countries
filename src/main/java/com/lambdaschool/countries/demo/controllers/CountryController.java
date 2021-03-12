package com.lambdaschool.countries.demo.controllers;

import com.lambdaschool.countries.demo.models.country;
import com.lambdaschool.countries.demo.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CountryController {
    @Autowired
    CountryRepository countrepos;
    private List <country> findCountries(List <Country>,myList, CheckCountry tester) {
        List<country> tempList = new ArrayList<>();

        for (country c : myList) {
            if (tester.test(c)) {
                tempList.add(c);
            }
        }
        return tempList;
    }
  // http://localhost:2019/countries/all
    @GetMapping(value="/names/all", produces = {"application/json"})
    public ResponseEntity<?> ListAllCountries(){
        List<country> mylist = new ArrayList<>()
                countrepos.findAll()
                        .iterator()
                        .forEachRemaining(myList::add);
        mylist.sort((e1, e2)->e1.getName().compareToIgnoreCase(e2).getName());
            return new ResponseEntity<>(mylist, HttpStatus.OK);
    }
    @GetMapping(value="/names/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> FilterByLetter(@PathVariable char letter){
        List<country> mylist = new ArrayList<>()
        countrepos.findAll()
                .iterator()
                .forEachRemaining(myList::add);

        List<country> rtnlist =findCountries(mylist, c =>c.getName().charAt(0)) == letter);
        return new ResponseEntity<>(rtnlist, HttpStatus.OK);
    }
}
