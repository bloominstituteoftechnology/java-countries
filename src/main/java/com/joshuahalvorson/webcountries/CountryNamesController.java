package com.joshuahalvorson.webcountries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class CountryNamesController {

    ///names/all
    @RequestMapping("/all")
    public ArrayList<String> getAllCountries(){
        ArrayList<String> names = new ArrayList<>();

        WebcountriesApplication.countriesList.countryList.sort((c1, c2) ->
                c1.getName().compareToIgnoreCase(c2.getName()));

        WebcountriesApplication.countriesList.countryList.forEach(country ->
                names.add(country.getName()));

        return names;
    }
}
