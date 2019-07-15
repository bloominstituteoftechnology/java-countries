package com.lambdaschool.countries;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;

@RestController
@RequestMapping("/age")
public class CountriesAge extends AbstractCountries {
    @RequestMapping("/age/{age}")
    public ArrayList<Country> getByAgeMin(@PathVariable int age){
        ArrayList<Country> temp=list.getCountryList();
        temp.removeIf(country -> country.getMedian_age()<age);
        return temp;
    }

    @RequestMapping("/min")
    public Country getMinMedianAge(){
        ArrayList<Country> temp=list.getCountryList();
        temp.sort(Comparator.comparingInt(Country::getMedian_age));
        return temp.get(0);
    }

    @RequestMapping("/max")
    public Country getMaxMedianAge(){
        ArrayList<Country> temp=list.getCountryList();
        temp.sort(Comparator.comparingInt(Country::getMedian_age));
        return temp.get(temp.size()-1);
    }

    @RequestMapping("/median")
    public Country getMedianMedianAge(){
        ArrayList<Country> temp=list.getCountryList();
        temp.sort(Comparator.comparingInt(Country::getMedian_age));
        if(temp.size()%2==1){
            return temp.get((temp.size()/2)+1);
        }else{
            return temp.get(temp.size()/2);
        }
    }
}
