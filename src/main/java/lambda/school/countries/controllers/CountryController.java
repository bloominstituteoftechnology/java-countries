package lambda.school.countries.controllers;

import lambda.school.countries.models.Country;
import lambda.school.countries.repositories.CountryRepository;
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
    private CountryRepository countryRepository;

    //http://localhost:2019/names/all

    @GetMapping(value = "/names/all", produces = "application/json")
    public ResponseEntity<?> findAllCountries() {
        List<Country> countries = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining(countries::add);

        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    //http:localhost:2019/population/total

    @GetMapping(value = "/population/total", produces = "application/json")
    public ResponseEntity<?> getTotal() {
        List<Country> countryList = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining(countryList::add);

        double Total = 0.0;
        for (Country c : countryList)
            Total += c.getPopulation();
        return new ResponseEntity<>(Total, HttpStatus.OK);

    }

    @GetMapping(value = "names/start/{letter}", produces = "application/json")
    public ResponseEntity<?> findByName(@PathVariable char letter){
        List <Country> countryList = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining(countryList::add);
        List<Country> filteredList = filterCountries(countryList,
                (country -> country.getName().charAt(0)==letter));
                return new ResponseEntity<>(filteredList, HttpStatus.OK);
    }
    private List<Country> filterCountries (List<Country> countryList,CheckCountries tester){
        List<Country> rtnList = new ArrayList<>();
        for (Country c: countryList){
            if(tester.test(c)){
                rtnList.add(c);
            }
        }
        return rtnList;
    }
    @GetMapping(value ="/population/min", produces = {"application/json"})
    public ResponseEntity<?> listPopulationMin()
    {
        List<Country> myList = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining(myList::add);

        myList.sort((e1, e2) -> (int)(e1.getPopulation()- (e2.getPopulation())));

        //MyList.get(0) returns first object based on sort (low)
        return new ResponseEntity<>(myList.get(0), HttpStatus.OK);
    }
//     http://localhost:2021/population/max

    @GetMapping(value ="/population/max", produces = {"application/json"})
    public ResponseEntity<?> listPopulationMax()
    {
        List<Country> myList = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining(myList::add);

        // Sorts High to Low
        myList.sort((e1, e2) -> (int)(e2.getPopulation()- (e1.getPopulation())));

        return new ResponseEntity<>(myList.get(0), HttpStatus.OK);
    }
}