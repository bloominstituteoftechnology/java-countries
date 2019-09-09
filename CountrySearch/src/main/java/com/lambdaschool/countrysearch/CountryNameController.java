package com.lambdaschool.countrysearch;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class CountryNameController
{
//    localhost:5000/names/all
//    return the names of all the countries alphabetically
    @GetMapping(value = "/all",
                produces = {"application/json"})
    public ResponseEntity<?> getAllCountries()
    {
        CountrysearchApplication.ourCountryList.countryList.sort((
                c1, c2) -> c1.getCountryName().compareToIgnoreCase(c2.getCountryName()));
        return new ResponseEntity<>(CountrysearchApplication.ourCountryList.countryList, HttpStatus.OK);
    }

//    localhost:5000/names/start/{letter}
//    return the countries alphabetically that begin with the given letter
    @GetMapping(value = "/start/{letter}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountriesByLetter(
            @PathVariable char letter)
    {
        ArrayList<Country> countries = CountrysearchApplication.ourCountryList
                .findCountries(c -> c.getCountryName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

//    localhost:5000/names/size/{number}
//    return the countries alphabetically that have a name equal to or longer than the given length
    @GetMapping( value = "/size/{number}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryGreaterThanByNameLength(
            @PathVariable int number)
    {
        ArrayList<Country> countries = CountrysearchApplication.ourCountryList
                .findCountries(c -> c.getCountryName().length() >= number);
            countries.sort((c1, c2) -> c1.getCountryName().compareToIgnoreCase(c2.getCountryName()));
            return new ResponseEntity<>(countries, HttpStatus.OK);
    }

}
