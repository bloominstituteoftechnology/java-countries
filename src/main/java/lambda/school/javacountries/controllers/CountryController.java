package lambda.school.javacountries.controllers;


import lambda.school.javacountries.models.Countries;
import lambda.school.javacountries.repositories.CountriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountriesRepository countriesRepository;

    @GetMapping(value = "/names/all", produces = "application/json")
    public ResponseEntity<?> findAllCountries() {
        List<Countries> countries = new ArrayList<>();

        countriesRepository.findAll().iterator().forEachRemaining(countries::add);

        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @GetMapping(value = "/names/start/{letter}", produces = "application/json")
    public ResponseEntity<?> findByName(@PathVariable char letter) {
        List<Countries> countriesList = new ArrayList<>();
        countriesRepository.findAll().iterator().forEachRemaining(countriesList::add);

        List<Countries> filteredList = filterCountries(countriesList,
                (c) -> c.getName().charAt(0) == letter);

        return new ResponseEntity<>(filteredList, HttpStatus.OK);
    }

    private List<Countries> filterCountries(List<Countries> countriesList, CountryCheck tester) {
        List<Countries> rtnList = new ArrayList<>();

        for (Countries c : countriesList) {
            if (tester.test(c)) {
                rtnList.add(c);
            }
        }
        return rtnList;
    }

    @GetMapping(value = "/population/total", produces = "application/json")
    public ResponseEntity<?> getTotal() {
        List<Countries> countriesList = new ArrayList<>();
        countriesRepository.findAll().iterator().forEachRemaining(countriesList::add);

        long total = 0;
        for (Countries c : countriesList) {
            total += c.getPopulation();
        }

        System.out.println("The World's Population is:" + total);

        return new ResponseEntity<>(total, HttpStatus.OK);
    }

    @GetMapping(value = "/population/min", produces = "application/json")
    public ResponseEntity<?> getMin() {
        List<Countries> countriesList = new ArrayList<>();
        countriesRepository.findAll().iterator().forEachRemaining(countriesList::add);

        countriesList.sort((c1, c2) -> (int) (c2.getPopulation() - c1.getPopulation()));

        Countries smallCountry = countriesList.get(countriesList.size() -1);

        return new ResponseEntity<>(smallCountry, HttpStatus.OK);

    }

    @GetMapping(value = "/population/max", produces = "application/json")
    public ResponseEntity<?> getMax() {
        List<Countries> countriesList = new ArrayList<>();
        countriesRepository.findAll().iterator().forEachRemaining(countriesList::add);

        countriesList.sort((c1, c2) -> (int) (c1.getPopulation() - c2.getPopulation()));

        Countries biggestCountry = countriesList.get(countriesList.size() -1);

        return new ResponseEntity<>(biggestCountry, HttpStatus.OK);

    }
}
