package com.lambdaschool.countries.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")

public class CountryNameController {
    @RequestMapping("/all")
    public ArrayList<Country> getCountryDetails() {
        CountriesApplication.countryList.countryList.sort((c1, c2)-> c1.getName().compareToIgnoreCase(c2.getName()));
        return CountriesApplication.countryList.countryList;
    }
}


