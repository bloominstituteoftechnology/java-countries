package lambda.school.countriesmp.controllers;

import lambda.school.countriesmp.models.Country;
import lambda.school.countriesmp.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping(value = "/population/max", produces = "application/json")
    public ResponseEntity <?> getMaxPopulation()
    {
        List <Country> countryList = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining(c -> countryList.add(c));
        countryList.sort((c1,c2) -> (c1.getPopulation()>c2.getPopulation()) ? -1:1);
        return new ResponseEntity<>(countryList.get(0), HttpStatus.OK);
    }

    @GetMapping(value = "/population/total", produces = "application/json")
    public ResponseEntity <?> getTotalPopulation()
    {
        List <Country> countryList = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining(c -> countryList.add(c));
        long population = 0;
        for (Country c: countryList)
        {
            population+=c.getPopulation();

        }
        System.out.println(population);
        return new ResponseEntity<>(population, HttpStatus.OK);
    }

    @GetMapping(value = "/names/all", produces = "application/json")
    public ResponseEntity <?> listAllCountries()
    {
        List <Country> countryList = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining(c -> countryList.add(c));
        return new ResponseEntity<>(countryList, HttpStatus.OK);
    }
}
