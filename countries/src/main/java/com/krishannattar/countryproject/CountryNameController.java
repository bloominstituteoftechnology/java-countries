package com.krishannattar.countryproject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class CountryNameController {

    @GetMapping(value = "/all",
    produces = "application/json")
    public ResponseEntity<?> getAllCountryNames()
    {
        return new ResponseEntity<>(CountryprojectApplication.ourCountryList.countryList, HttpStatus.OK);
    }

    @GetMapping(value="/start/{letter}",
    produces = "application/json")
    public ResponseEntity<?> getCountriesByFirstLetter(@PathVariable char letter)
    {
        ArrayList<Country> returnCountries = CountryprojectApplication.ourCountryList.findCountries(c->c.getName().toUpperCase().charAt(0)==Character.toUpperCase(letter));
        returnCountries.sort((c1,c2)-> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(returnCountries,HttpStatus.OK);
    }

    @GetMapping(value = "/size/{number}",
    produces = "application/json")
    public ResponseEntity<?> getCountriesByNameLength(@PathVariable int number)
    {
        ArrayList<Country> returnCountries = CountryprojectApplication.ourCountryList.findCountries(c->c.getName().length() >= number);
        returnCountries.sort((c1,c2)->c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(returnCountries,HttpStatus.OK);
    }
}
