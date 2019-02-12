package com.example.countries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// localhost:8080/calc/salary?id=1&raise=0.5
@RestController
@RequestMapping("/calc")
public class CalculationController
{
    @RequestMapping("/salary")
    public Country checkRaise(@RequestParam(value = "name") String name,
                              @RequestParam(value = "population") int population)
    {
        Country tempCountry = new Country(CountriesApplication.ourCountryList.findCountry(c -> (c.getName().equals(name))));
        tempCountry.setPopulation(tempCountry.getPopulation() * (1 + population));
        return tempCountry;
    }



}