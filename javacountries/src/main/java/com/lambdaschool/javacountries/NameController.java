package com.lambdaschool.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/name")
public class NameController
{
    //  http://localhost:8080/name/all
    @GetMapping(value = "/all",
                produces = {"application/json"})
    //java method that it will run:
    public ResponseEntity<?> getAllCountries()
    {
        //will return all countries
        //with a GET, we send back: Data. Status
        //Main class: data we want is a field
        //object: theCountriesL
        //inside the object, we have a field we want: countryList
        return new ResponseEntity<>(JavacountriesApplication.theCountriesL.countryList, HttpStatus.OK);
    }


}
