package com.lambdaschool.javacountries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/age")
public class CountryAgeController {

    @RequestMapping("/age")
    public List<Country> age(@RequestParam(value = "age") String n)
    {
       
        JavaCountriesApplication.listcountry.countryList.sort(Comparator.comparingInt(Country::getMedianAge));
        return JavaCountriesApplication.listcountry.countryList
                .stream()
                .filter((c) -> c.getMedianAge() >= Integer.parseInt(n))
                .collect(Collectors.toList());
    }

    @RequestMapping("/min")
    public Country getCountrywithLowestMinAge()
    {

        return JavaCountriesApplication.listcountry.countryList
                .stream()
                .min(Comparator.comparing(Country::getMedianAge))
                .orElseThrow(NoSuchElementException::new);
    }

    @RequestMapping("/max")
    public Country getCountryWithGreatestMinAge()
    {
        return JavaCountriesApplication.listcountry.countryList
                .stream()
                .max(Comparator.comparing(Country::getMedianAge))
                .orElseThrow(NoSuchElementException::new);
    }


}
