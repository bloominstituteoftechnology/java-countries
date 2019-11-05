package com.versilistyson.javacountriesassignment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class CountryController {
    @GetMapping(
            value = "/allcountries",
            produces = {"application/json"}
    )
    public ResponseEntity<?> getAllCountries() {
        JavaCountriesAssignmentApplication.myCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(JavaCountriesAssignmentApplication.myCountryList.countryList, HttpStatus.OK);
    }
}
