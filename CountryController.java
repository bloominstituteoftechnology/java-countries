package com.example.countries;
//localhost:8080/data/allCountries

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CountryController
{
//  return the names of all the countries alphabetically
    @RequestMapping("/names/allCountries")
    public ArrayList<String> getAllCountries()
    {
        ArrayList<String> newList = new ArrayList<>();
        for (Country c : CountriesApplication.ourCountryList.countryList)
            newList.add(c.getName());
        newList.sort((c1, c2) -> c1.compareToIgnoreCase(c2));
        return newList;
    }

//  return the countries alphabetically that begin with the given letter
    @RequestMapping("/names/begin")
    public ArrayList<Country> getCountryDetail(@RequestParam(value = "letter") char letter)
    {
        ArrayList<Country> newList = new ArrayList<>();
        for (Country c : CountriesApplication.ourCountryList.countryList)
            if (c.getName().charAt(0) == Character.toUpperCase(letter))
                newList.add(c);
        newList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return newList;
    }

//  return the countries alphabetically that have a name equal to or longer than the given length
    @RequestMapping("/names/size")
    public ArrayList<Country> getCountrySize(@RequestParam(value = "letters") int letters)
    {
        ArrayList<Country> newList = new ArrayList<>();
        for (Country c : CountriesApplication.ourCountryList.countryList)
            if (c.getName().length() == letters)
                newList.add(c);
        newList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return newList;
    }

//  return the countries that have a population equal to or greater than the given population
    @RequestMapping("/population/size")
    public ArrayList<Country> getPopulationSize(@RequestParam(value = "people") int people)
    {
        ArrayList<Country> newList = new ArrayList<>();
        for (Country c : CountriesApplication.ourCountryList.countryList)
            if (c.getPopulation() >= people)
                newList.add(c);
        newList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return newList;
    }

//  return the country with the smallest population
    @RequestMapping("/population/min")
    public Country getMinPopulation()
    {
        int min = 1000000000;
        Country minCountry = new Country("NA", 0, 0, 0);
        for (Country c : CountriesApplication.ourCountryList.countryList) {
            if (c.getPopulation() <= min) {
                min = c.getPopulation();
                minCountry = c;
            }
        }
        return minCountry;
    }

//  return the country with the largest population
    @RequestMapping("/population/max")
    public Country getMaxPopulation()
    {
        int max = 0;
        Country maxCountry = new Country("NA", 0, 0, 0);
        for (Country c : CountriesApplication.ourCountryList.countryList) {
            if (c.getPopulation() >= max) {
                max = c.getPopulation();
                maxCountry = c;
            }
        }
        return maxCountry;
    }

//  return the countries that have a median age equal to or greater than the given age
    @RequestMapping("/age/age")
    public ArrayList<Country> getByAge(@RequestParam(value = "age") int age)
    {
        ArrayList<Country> newList = new ArrayList<>();
        for (Country c : CountriesApplication.ourCountryList.countryList)
            if (c.getMedianAge() == age)
                newList.add(c);
        newList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return newList;
    }

//  return the country with the smallest population
    @RequestMapping("/age/min")
    public Country getMinAge()
    {
        int min = 1000;
        Country minCountry = new Country("NA", 0, 0, 0);
        for (Country c : CountriesApplication.ourCountryList.countryList) {
            if (c.getMedianAge() <= min) {
                min = c.getMedianAge();
                minCountry = c;
            }
        }
        return minCountry;
    }

//  return the country with the largest population
    @RequestMapping("/age/max")
    public Country getMaxAge()
    {
        int max = 0;
        Country maxCountry = new Country("NA", 0, 0, 0);
        for (Country c : CountriesApplication.ourCountryList.countryList) {
            if (c.getMedianAge() >= max) {
                max = c.getMedianAge();
                maxCountry = c;
            }
        }
        return maxCountry;
    }
}
