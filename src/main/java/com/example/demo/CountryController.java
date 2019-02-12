package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;

@RestController
public class CountryController {

    @RequestMapping("names/all")
    public ArrayList<Country> getAllCountries() {
        ArrayList<Country> countries = JavacountriesApplication.list.countryList;
        countries.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        return countries;
    }

    @RequestMapping("names/begin")
    public ArrayList<Country> getCountriesByLetter(@RequestParam(value = "letter") String letter) {
        ArrayList<Country> countries = JavacountriesApplication.list.findCountries(e -> (e.getName().substring(0, 1).toLowerCase().equals(letter.toLowerCase())));
        countries.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        return countries;
    }

    @RequestMapping("names/size")
    public ArrayList<Country> getCountriesGreaterThanByNameLength(@RequestParam(value = "letters") int length) {
        ArrayList<Country> countries = JavacountriesApplication.list.findCountries(e -> (e.getName().length() > length));
        countries.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        return countries;
    }

    @RequestMapping("population/size")
    public ArrayList<Country> getCountriesGreaterThanByPop(@RequestParam(value = "people") int pop) {
        return JavacountriesApplication.list.findCountries(e -> (e.getPopulation() > pop));
    }

    @RequestMapping("population/min")
    public Country getCountriesPopMin() {
        JavacountriesApplication.list.countryList.sort(Comparator.comparingLong(Country::getPopulation));
        return JavacountriesApplication.list.countryList.get(0);
    }

    @RequestMapping("population/max")
    public Country getCountriesPopMax() {
        JavacountriesApplication.list.countryList.sort(Comparator.comparingLong(Country::getPopulation));
        return JavacountriesApplication.list.countryList.get(JavacountriesApplication.list.countryList.size() - 1);
    }

    @RequestMapping("age/age")
    public ArrayList<Country> getCountriesGreaterThanByAge(@RequestParam(value = "age") int ageInput) {
        return JavacountriesApplication.list.findCountries(e -> (e.getAge() > ageInput));
    }

    @RequestMapping("age/min")
    public Country getCountriesAgeMin() {
        JavacountriesApplication.list.countryList.sort(Comparator.comparingLong(Country::getAge));
        return JavacountriesApplication.list.countryList.get(0);
    }

    @RequestMapping("age/max")
    public Country getCountriesAgeMax() {
        JavacountriesApplication.list.countryList.sort(Comparator.comparingLong(Country::getAge));
        return JavacountriesApplication.list.countryList.get(JavacountriesApplication.list.countryList.size() - 1);
    }

}