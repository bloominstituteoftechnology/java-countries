package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/data")
public class CountryController {
    @GetMapping(value = "/names/all",
    produces ={"application/json"})
    public ResponseEntity<?> AlphabeticalNames(){
        CountriesApplication.ourCountryList.countryList.sort((c1,c2)-> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(CountriesApplication.ourCountryList.countryList,HttpStatus.OK);
    }

    @GetMapping(value = "/names/start/{letter}",
    produces = {"application/json"})
    public ResponseEntity<?> getCountryByLetter(@PathVariable char letter)
    {
        List <Country> rtnCountrys = CountriesApplication.ourCountryList.
                findC((c-> c.getName().toUpperCase().charAt(0)== Character.toUpperCase((letter))));
        return new ResponseEntity<>(rtnCountrys, HttpStatus.OK);
    }

    @GetMapping(value = "/name/size/{number}",
    produces = {"application/json"})
    public ResponseEntity<?> AlphabeticalLength(@PathVariable int number){
        List <Country> ALCountry = CountriesApplication.ourCountryList.
                findC((c-> c.getName().length() >= number));
        List <Country> sortedList = new ArrayList<>(ALCountry);
        sortedList.sort((a1, a2) -> a1.getName().compareToIgnoreCase(a2.getName()));
        return new ResponseEntity<>(sortedList,HttpStatus.OK);

    }

    ///population/size/{people} - return the countries that have a population equal to or greater than the given population
    @GetMapping(value = "/population/size/{people}",
            produces = {"application/json"})
    public ResponseEntity<?> Population(@PathVariable int people){
        List<Country> Poplist = CountriesApplication.ourCountryList.
                findC((c-> c.getPopulation()>= people));
        return new ResponseEntity<>(Poplist, HttpStatus.OK);
    }
    @GetMapping(value = "/population/min",
            produces = {"application/json"})
    public ResponseEntity<?> Smallest(){
        List<Country> SmallCountry = CountriesApplication.ourCountryList
                .findC(c-> c.getPopulation() > 0);
        SmallCountry.sort(Comparator.comparing(c -> c.getPopulation(), Comparator.reverseOrder()));

//        Country small = SmallCountry.get(SmallCountry.size()-1);
        return new ResponseEntity<>(SmallCountry.get(SmallCountry.size()-1), HttpStatus.OK);

    }
//     /population/max - return the country with the smallest population
    @GetMapping(value = "/population/max",
    produces = {"application/json"})
    public ResponseEntity<?> Biggest(){
        List<Country> MaxCountry = CountriesApplication.ourCountryList
                .findC(c-> c.getPopulation() > 0);
//        Country Big
        return new ResponseEntity<>(MaxCountry.get(0), HttpStatus.OK);

    }
// /age/age/{age} - return the countries that have a median age equal to or greater than the given age
    @GetMapping(value = "/age/{age}",
    produces = {"application/json"})
    public ResponseEntity<?> Age (@PathVariable int age) {
        List<Country> AgedCountry = CountriesApplication.ourCountryList
                .findC(c -> c.getAge() >= age);
        return new ResponseEntity<>(AgedCountry, HttpStatus.OK);
    }

    // /age/min - return the country with the smallest median age
    @GetMapping(value = "/age/min",
            produces = {"application/json"})
    public ResponseEntity<?> MinAge(){
        List<Country> tiny= CountriesApplication.ourCountryList
                .findC(c -> c.getAge()> 0);
        tiny.sort(Comparator.comparing(c -> c.getAge(), Comparator.reverseOrder()));
        return new ResponseEntity<>(tiny.get(tiny.size()-1), HttpStatus.OK);

    }

//     /age/max - return the country the the greatest median age

    @GetMapping(value = "/age/max",
            produces = {"application/json"})
    public ResponseEntity<?> BigAge() {
        List<Country> biggestAge = CountriesApplication.ourCountryList
                .findC(c -> c.getPopulation() > 0);
        biggestAge.sort(Comparator.comparing(c -> c.getAge(), Comparator.reverseOrder()));
//        Country Big
        return new ResponseEntity<>(biggestAge.get(0), HttpStatus.OK);
    }

}
