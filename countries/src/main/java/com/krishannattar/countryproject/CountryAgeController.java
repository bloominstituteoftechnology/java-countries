package com.krishannattar.countryproject;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/age")
public class CountryAgeController {

    @GetMapping(value = "/age/{age}",
    produces = "application/json")
    public ResponseEntity<?> getCountriesByMedianAge(@PathVariable int age)
    {
        ArrayList<Country> returnCountries = new ArrayList<>();
        returnCountries = CountryprojectApplication.ourCountryList.findCountries(c->c.getMedianAge() >= age);
        returnCountries.sort((c1,c2)->c2.getMedianAge()-c1.getMedianAge());
        return new ResponseEntity<>(returnCountries, HttpStatus.OK);
    }

    @GetMapping(value = "/min",
    produces = "application/json")
    public ResponseEntity<?> getLowestMedianAge()
    {
        ArrayList<Country> returnCountries = (ArrayList) CountryprojectApplication.ourCountryList.countryList;
        returnCountries.sort((c1,c2)->c1.getMedianAge()-c2.getMedianAge());
        return new ResponseEntity<>(returnCountries.get(0), HttpStatus.OK);

    }

    @GetMapping(value = "/max",
            produces = "application/json")
    public ResponseEntity<?> getLargestMedianAge()
    {
        ArrayList<Country> returnCountries = (ArrayList) CountryprojectApplication.ourCountryList.countryList;
        returnCountries.sort((c1,c2)->c2.getMedianAge()-c1.getMedianAge());
        return new ResponseEntity<>(returnCountries.get(0), HttpStatus.OK);

    }

    @GetMapping(value = "/median",
            produces = "application/json")
    public ResponseEntity<?> getMedianMedianAge()
    {
        ArrayList<Country> returnCountries = (ArrayList) CountryprojectApplication.ourCountryList.countryList;
        returnCountries.sort((c1,c2)->c2.getMedianAge()-c1.getMedianAge());
        int medianCountry = returnCountries.size() /2;
        return new ResponseEntity<>(returnCountries.get(medianCountry), HttpStatus.OK);

    }
}
