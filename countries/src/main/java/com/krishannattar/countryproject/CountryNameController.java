package com.krishannattar.countryproject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/names")
public class CountryNameController {

    @GetMapping(value = "/all",
    produces = "application/json")
    public ResponseEntity<?> getAllCountryNames()
    {
        return new ResponseEntity<>(CountryprojectApplication.ourCountryList.countryList, HttpStatus.OK);
    }
}
