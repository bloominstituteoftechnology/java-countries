package com.lambdaschool.countries.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.lambdaschool.countries.controllers.CheckCountry;
import com.lambdaschool.countries.models.Country;
import com.lambdaschool.countries.repositories.CounrtryRepo;

import org.springframework.beans.factory.annotation.Autowired;

public class CountryServiceImpl implements CountryService {

    @Autowired
    CounrtryRepo countryrepo;


    private List<Country> findCountries(List<Country> list, CheckCountry tester){
        List<Country> tempList = new ArrayList<>();
        for (Country c : list){
            if(tester.test(c)){
                tempList.add(c);
            }
        }
        return tempList;
    }

    @Override
    public List<Country> countriesAlphabetical() {
        List<Country> allCountries = new ArrayList<>();
        countryrepo.findAll().iterator().forEachRemaining(allCountries::add);
        allCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return allCountries;
    }

    @Override
    public List<Country> filterCountriesByGivenLetter(char letter) {
        // TODO Auto-generated method stub
        List<Country> allCountries = new ArrayList<>();
        countryrepo.findAll().iterator().forEachRemaining(allCountries::add);

        List<Country> rtnList = findCountries(allCountries, c -> c.getName.charAt(0) == letter);

        rtnList.forEach(country -> System.out.println(country));
        return rtnList;
    }

    @Override
    public long populationTotal() {
        // TODO Auto-generated method stub
        List<Country> allCountries = new ArrayList<>();
        countryrepo.findAll().iterator().forEachRemaining(allCountries::add);
        int populationTotal = allCountries.sort((c1, c2) -> (int)(c1.getPopulation() + c2.getPopulation()))
        return (long)populationTotal;
    }

    @Override
    public Country smallestPop() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Country largestPop() {
        // TODO Auto-generated method stub
        return null;
    }


    
}