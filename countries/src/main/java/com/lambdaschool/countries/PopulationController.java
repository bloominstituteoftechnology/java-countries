package com.lambdaschool.countries;


import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

//Java Sprint Rest APIs -> Java Back End
@RestController
@RequestMapping("/names")
public class PopulationController{



    //return the countries that have a population equal to or greater than the given population

    //size/people
    //return the country with the smallest population
    @GetMapping(value = "/size/{people}",
                produces = {"application/json"})
    public ResponseEntity<?>getCountriesbyPopulation(@PathVariable long people)
    {
        ArrayList<Country> returnArrayList= WebCountriesApplication.ourCountryList
                .findCountries(c -> c.getPopulations() <= (people));

            return new ResponseEntity<>(returnArrayList, HttpStatus.OK);
    }

    //population/min
    //return the country with the smallest population

    @GetMapping(value = "population/min",
                produces = {"application/json"})
    public ResponseEntity<?>getCountriesMinPopulation(@PathVariable long people){
//    App this is the main class;
//             OurCountryList-object in main class;
//                                  countryList is the for loop
       WebCountriesApplication.ourCountryList.countryList.sort((c1, c2)-> (int)
               (c1.getPopulations()-c2.getPopulations()));
                Country returnArrayList =
            WebCountriesApplication.ourCountryList.countryList.get(0);
            return new ResponseEntity<>(returnArrayList, HttpStatus.OK);

    ///population/max
    //return the country with the largest population
    }
    @GetMapping(value = "population/max",
                produces = {"application/json"})
    public ResponseEntity<?>getCountriesMaxPopulation(@PathVariable long people)
    {

        WebCountriesApplication.ourCountryList.countryList.sort((c1, c2) -> (int)
                (c2.getPopulations() - c1.getPopulations()));
        Country returnArrayList =
        WebCountriesApplication.ourCountryList.countryList.get(0);
        return new ResponseEntity<>(returnArrayList, HttpStatus.OK);
    }
}

