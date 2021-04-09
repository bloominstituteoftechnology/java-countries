package lambda.school.demo.controllers;

import lambda.school.demo.models.Country;
import lambda.school.demo.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController
{
    @Autowired
    private CountryRepository countryRepository;
//    http://localhost:2019/names/all

    @GetMapping(value = "/names/all", produces = "application/json")
    public ResponseEntity<?> getAllCountries()
    {
        List<Country> countriesList = new ArrayList<>();

        countryRepository.findAll().iterator().forEachRemaining(countriesList::add);

        countriesList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));

        return  new ResponseEntity<>(countriesList, HttpStatus.OK);
    }

//    http://localhost:2019/names/start/u

    @GetMapping(value = "/names/start/{letter}", produces = "application/json")
    public ResponseEntity<?> findByName(@PathVariable char letter)
    {
        List<Country> countryList = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining(countryList::add);

        List<Country> filteredList = filteredCountries(countryList, (c) -> c.getName().charAt(0) == letter);
        return new ResponseEntity<>(filteredList,HttpStatus.OK);
    }

    private List<Country> filteredCountries(List<Country> countryList, CheckCountries tester)
    {
        List<Country> rtnList = new ArrayList<>();

        for (Country c: countryList) {
            if (tester.test(c)) {
                rtnList.add(c);
            }
        }
        return rtnList;
    }

//    http://localhost:2019/population/total

    @GetMapping(value = "/population/total", produces = "application/json")
    public ResponseEntity<?> getTotal()
    {
        List<Country> countryList = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining(countryList::add);

        long total = 0;
        for (Country c : countryList)
        {
            total += c.getPopulation();
        }
        System.out.println("World Population is: " + total);
        return new ResponseEntity<>(total, HttpStatus.OK);
    }

//    http://localhost:2019/population/min

    @GetMapping(value = "/population/min", produces = "application/json")
    public ResponseEntity<?> getMin()
    {
        List<Country> countryList = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining(countryList::add);

        countryList.sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()));

        Country rtnCountry = countryList.get(0);
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }
//    http://localhost:2019/population/max

    @GetMapping(value = "/population/max", produces = "application/json")
    public ResponseEntity<?> getMax()
    {
        List<Country> countryList = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining(countryList::add);

        countryList.sort((c1, c2) -> (int)(c2.getPopulation() - c1.getPopulation()));

        Country rtnCountry = countryList.get(0);
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

//    http://localhost:2019/population/median
    @GetMapping(value = "/population/median", produces = "application/json")
    public ResponseEntity<?> getMedian()
    {
        List<Country> countryList = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining(countryList::add);
        countryList.sort((c1, c2) -> (int)(c2.getPopulation() - c1.getPopulation()));

        Country rtnCountry = countryList.get((countryList.size() / 2) + 1);

        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }
}
