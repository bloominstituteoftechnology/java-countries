package com.lambdaschool.countries;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import static java.lang.Character.toUpperCase;

//Java Sprint Rest APIs -> Java Back End
@RestController
@RequestMapping("/names")
public class CountryController

{
    //return the names of all the countries alphabetically
    //localhost:2019/names/all
    @GetMapping(value = "/all",
                produces = {"application/json"})
    public ResponseEntity<?> getAllCountries()
    {
        return new ResponseEntity<>(WebCountriesApplication.ourCountryList.countryList, HttpStatus.OK);
    }

    //return the countries alphabetically that begin with the given letter
    //localhost:5000/names/start/{letter}
    @GetMapping(value = "/start/{letter}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountriesByFirsLetter(
            @PathVariable
                    char letter)
    {
        ArrayList<Country> returnArrayList = WebCountriesApplication.ourCountryList.findCountries(c -> c.getCountryName().toUpperCase().charAt(0)== toUpperCase(letter));
        returnArrayList.sort((c1, c2) -> c1.getCountryName().compareToIgnoreCase(c2.getCountryName()));
        return new ResponseEntity<>(returnArrayList, HttpStatus.OK);
    }


//    ************
//    @GetMapping(value = "/start/{letter}")
    //   public ResponseEntity<?> return1stLetter(
    //           @PathVariable
    //                   char letter)
    //   {
    //       ArrayList<Country> returnArrayList = CountriesApplication.ourCountries.findCountry(c -> c.getCountryName().toUpperCase().charAt(0) == toUpperCase(letter));
    //       returnArrayList.sort((c1, c2) -> c1.getCountryName().compareToIgnoreCase(c2.getCountryName()));
    //       return new ResponseEntity<>(returnArrayList, HttpStatus.OK);
    //   }
//    ***********



    //return the countries alphabetically that have a name equal to or longer than the given length
    //localhost:5000/countries/size/number/
    @GetMapping(value = "/size/{number}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountriesByNameLength(
            @PathVariable
                    int number)
    {
        ArrayList<Country> returnArrayList = WebCountriesApplication.ourCountryList.findCountries(c -> c.getCountryName().length() >= (number));

        returnArrayList.sort((c1, c2) -> c1.getCountryName().compareToIgnoreCase(c2.getCountryName()));
        return new ResponseEntity<>(returnArrayList, HttpStatus.OK);

    }
}

