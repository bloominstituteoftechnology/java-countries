package com.lambdaschool.countries;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class CountriesPopulation extends AbstractCountries {
    @RequestMapping("/size/{people}")
    public ArrayList<Country> getPopulationGreater(@PathVariable int people){
        ArrayList<Country> temp=list.getCountryList();
        temp.removeIf(country -> (int)country.getSize()<people);
        return temp;
    }

    @RequestMapping("/min")
    public Country getMin(){
        ArrayList<Country> temp=list.getCountryList();
        temp.sort((Country c1, Country c2)->(int)(c1.getPopulation()-c2.getPopulation()));
        return temp.get(0);
    }

    @RequestMapping("/max")
    public Country getMax(){
        ArrayList<Country> temp=list.getCountryList();
        temp.sort((Country c1, Country c2)->(int)(c2.getPopulation()-c1.getPopulation()));
        return temp.get(0);
    }

    @RequestMapping("/median")
    public Country getMedian(){
        ArrayList<Country> temp=list.getCountryList();
        temp.sort((Country c1, Country c2)->(int)(c1.getPopulation()-c2.getPopulation()));
        if(temp.size()%2==1){
            return temp.get((temp.size()/2)+1);
        }else{
            return temp.get(temp.size()/2);
        }
    }
}
