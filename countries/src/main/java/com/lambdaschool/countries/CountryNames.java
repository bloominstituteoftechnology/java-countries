package com.lambdaschool.countries;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class CountryNames extends AbstractCountries{

    @RequestMapping("/all")
    public ArrayList<Country> getAll(){
        ArrayList<Country> temp = list.getCountryList();
        temp.sort((Country c1, Country c2)-> c1.getName().compareToIgnoreCase(c2.getName()));
        return temp;
    }
    @RequestMapping("/start/{letter}")
    public ArrayList<Country> getNameStart(@PathVariable String letter){
        ArrayList<Country> temp=list.getCountryList();
        temp.removeIf(c-> !c.getName().substring(0,1).equalsIgnoreCase(letter));
        return temp;
    }

    @RequestMapping("/size/{number}")
    public ArrayList<Country> getNameSize(@PathVariable int number){
        ArrayList<Country> temp=list.getCountryList();
        temp.removeIf(c->c.getName().length()<number);
        return temp;
    }
}
