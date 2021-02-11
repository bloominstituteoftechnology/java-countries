package com.example.javacountries;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/data")
public class CountryController {

    @GetMapping(value = "/allcountries",
    produces = {"application/json"})
    public ResponseEntity<?> getCountries(){
        JavacountriesApplication
                .myCountryList
                .countryList.sort((e1, e2) -> e1.getCountry_name()
                .compareToIgnoreCase(e2.getCountry_name()));
                return new ResponseEntity<>(JavacountriesApplication
                .myCountryList
                .countryList,
                        HttpStatus.OK);
    }
    @GetMapping(value = "/countries/{letter}",
    produces = {"application/json"})
    public ResponseEntity<?> getCountriesByLetter(@PathVariable char letter){
        ArrayList<Country> alphabeticalCountry = JavacountriesApplication
                .myCountryList
                .findCountry(e -> e.getCountry_name().toUpperCase()
                .charAt(0)== Character.toUpperCase(letter));
        alphabeticalCountry.sort((e1, e2) -> e1.getCountry_name()
                .compareToIgnoreCase(e2.getCountry_name()));
        return new ResponseEntity<>(alphabeticalCountry, HttpStatus.OK);
    }

    //  /names/size/{number}
    // localhost: 2019/names/size/{number}
    @GetMapping(value = "/size/{number}")
    public ResponseEntity<?> getCountriesNameSize(@PathVariable int number) {
        ArrayList<Country> rtnNames = JavacountriesApplication.myCountryList.findCountry(c -> c.getCountry_name().length() >= number);
        rtnNames.sort((c1, c2) -> c1.getCountry_name().compareToIgnoreCase(c2.getCountry_name()));
        return new ResponseEntity<>(rtnNames, HttpStatus.OK);
    }

}
