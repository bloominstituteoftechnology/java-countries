package com.shoon.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/data")
public class CountryController
{
    //localhost:8080/data/allCountries
    @RequestMapping(value = "/allCountries",
                    produces = {"application/json"})
    public ResponseEntity<?> getAllCountrys()
    {
        JavaCountriesApplication.countryList.countryList.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        return new ResponseEntity<>(JavaCountriesApplication.countryList.countryList, HttpStatus.OK);
    }


    // the web way
    // localhost:8080/data/Country?id=2
    @RequestMapping(value = "/Country",
                    method = RequestMethod.GET,
                    produces = {"application/json"})
    public ResponseEntity<?> getCountryDetail(
            @RequestParam("id")
                    long id)
    {
        Country rtnCountry = JavaCountriesApplication.countryList.findCountry(e -> (e.getID() == id));
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }


    // the restful way
    // localhost:8080/data/Country/2
    @GetMapping(value = "/Country/{id}",
                produces = {"application/json"})
    public ResponseEntity<?> getEmpDetail(
            @PathVariable
                    long id)
    {
        Country rtnCountry  = JavaCountriesApplication.countryList.findCountry(e -> (e.getID() == id));
        return new ResponseEntity<>(rtnCountry , HttpStatus.OK);
    }

    // localhost:8080/data/Countrys/s
    @GetMapping(value = "/Countrys/{letter}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountrys(
            @PathVariable
                    char letter)
    {
        ArrayList<Country> rtnEmps = JavaCountriesApplication.countryList.
                findCountrys(e -> e.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        return new ResponseEntity<>(rtnEmps, HttpStatus.OK);
    }


}
