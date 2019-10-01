package com.krishannattar.countryproject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;

@RestController
@RequestMapping("/population")
public class CountryPopulationController {



    @GetMapping(value = "/size/{people}",
            produces = "application/json")
    public ResponseEntity<?> getCountriesByNameLength(@PathVariable long people)
    {
        ArrayList<Country> returnCountries = CountryprojectApplication.ourCountryList.findCountries(c->c.getPopulation()>=people);
        returnCountries.sort((c1,c2)->c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(returnCountries,HttpStatus.OK);
    }

    @GetMapping(value = "/min",
    produces = "application/json")
    public ResponseEntity<?> findLowestPopulation()
    {
        ArrayList<Country> returnCountries = (ArrayList) CountryprojectApplication.ourCountryList.countryList;

        returnCountries.sort((c1,c2)->(int)(c1.getPopulation() - c2.getPopulation()));


//        ArrayList<Country> cloneReturnCountries = new ArrayList<>();
//
//        Iterator<Country> interator = returnCountries.iterator();
//        while(interator.hasNext()){
//            cloneReturnCountries.add((Country) interator.next().clone());
//        }

//        for (Country c: returnCountries)
//        {
//            cloneReturnCountries.add(c);
//        }

//        returnCountries.add(new Country("Jeep", 23,255,23));
        return new ResponseEntity<>(returnCountries.get(0), HttpStatus.OK);
    }
}
