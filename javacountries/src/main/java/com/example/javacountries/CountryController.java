package com.example.javacountries;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
