package com.lambdaschool.countries.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")

public class CountryNameController {
    @RequestMapping("/begin")
    public ArrayList<Country> filteredCountry(@RequestParam(value="letter")String letter){
            ArrayList<Country> filtered = new ArrayList<>();
            for(Country a : CountriesApplication.countryList.countryList) {
                String name = a.getName();
                String firstLetter = "";
                firstLetter = String.valueOf(name.charAt(0));
                if(firstLetter.equals(letter.toUpperCase())){
                    filtered.add(a);
                }
            }

            return filtered;
        }


    @RequestMapping("/all")
    public ArrayList<Country> getAllCountry() {
        CountriesApplication.countryList.countryList.sort((c1, c2)-> c1.getName().compareToIgnoreCase(c2.getName()));
        return CountriesApplication.countryList.countryList;
    }

    @RequestMapping("/size")
    public ArrayList<Country> filteredCountryBySize(@RequestParam(value="letters") int letters)
    {
        ArrayList<Country> filtered = new ArrayList<>(CountriesApplication.countryList.countryList);
        filtered.removeIf(c -> c.getName().length() < letters );
        return filtered;
    }
}


