package com.lambdaschool.javacountries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/names")
public class CountryNamesController {

//    /names/all
    @RequestMapping("/all")
    public ArrayList<String> getAllCountries(){

        ArrayList<String> name = new ArrayList<>();
        JavaCountriesApplication.listcountry.countryList.sort((c1, c2)->
                c1.getName().compareToIgnoreCase(c2.getName()));

        JavaCountriesApplication.listcountry.countryList.forEach(
                c ->name.add(c.getName()));

        return name;
    }

    @RequestMapping("/begin")
    public List<Country> getCountriesBeginningWithLetter(@RequestParam(value = "letter") String letter){
        return JavaCountriesApplication.listcountry.countryList.stream()
                .filter((c) -> c.getName().toLowerCase().startsWith(letter.toLowerCase())).collect(Collectors.toList());
    }

    @RequestMapping("/size")
    public List<Country> getCountriewithNameSizeEqualorLonger(@RequestParam(value = "letters") String string)
    {
        JavaCountriesApplication.listcountry.countryList.sort((c1, c2)->
                c1.getName().compareToIgnoreCase(c2.getName()));
        return JavaCountriesApplication.listcountry.countryList.stream()
                .filter((c) -> c.getName().length() >= Integer.parseInt(string)).collect(Collectors.toList());

    }

}
