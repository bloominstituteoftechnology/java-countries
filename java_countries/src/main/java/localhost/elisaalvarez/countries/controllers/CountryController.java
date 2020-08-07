package localhost.elisaalvarez.countries.controllers;

import localhost.elisaalvarez.countries.country.Country;
import localhost.elisaalvarez.countries.repositories.CountryReprository;
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
    CountryReprository countryrepos;

    private List<Country> findCountries(List<Country> myList, CheckCountries tester)
    {
        List<Country> tempList = new ArrayList<>();

        for (Country c : myList)
        {
            if (tester.test(c))
            {
                tempList.add(c);
            }
        }
        return tempList;
    }

    @GetMapping(value = "/names/all", produces = {"application/json"})
    public ResponseEntity<?> listAllCountries()
    {
        List<Country> myList  = new ArrayList<>();
        countryrepos.findAll().iterator().forEachRemaining(myList::add);
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }
    //http://localhost:2019/names/start/u
    @GetMapping(value = "/names/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> listAllCountriesByFirstLetter(@PathVariable char letter)
    {
        List<Country> myList = new ArrayList<>();
        countryrepos.findAll().iterator().forEachRemaining(myList::add);
        List<Country> rtnList = findCountries(myList, e -> e.getName().charAt(0) == letter);
        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }
    //http://localhost:2019/population/total
    @GetMapping(value = "/population/total", produces = {"application/json"})
    public ResponseEntity<?> populationTotal()
    {
        List<Country> myList = new ArrayList<>();
        countryrepos.findAll().iterator().forEachRemaining(myList::add);

        long totalPopulation = 0;
        for (Country c : myList)
        {
            totalPopulation = totalPopulation + c.getPopulation();
        }
        return new ResponseEntity<>("The Total Population is "+ totalPopulation, HttpStatus.OK);
    }

    // http://localhost:2019/population/min
    @GetMapping(value = "population/min", produces ={"application/json"})
    public ResponseEntity<?> minPopulation()
    {
        List<Country> myList = new ArrayList<>();
        countryrepos.findAll().iterator().forEachRemaining(myList::add);
        myList.sort((c1, c2) -> (int) (c2.getPopulation() - c1.getPopulation()));
        Country c = myList.get(myList.size() -1);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    // http://localhost:2019/population/max
    @GetMapping(value = "population/max", produces ={"application/json"})
    public ResponseEntity<?> maxPopulation()
    {
        List<Country> myList = new ArrayList<>();
        countryrepos.findAll().iterator().forEachRemaining(myList::add);
        myList.sort((c1, c2) -> (int) (c1.getPopulation() - c2.getPopulation()));
        Country c = myList.get(myList.size() -1);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }



    // http://localhost:2019/population/median
    @GetMapping(value = "population/median", produces ={"application/json"})
    public ResponseEntity<?> medianPopulation()
    {
        List<Country> myList = new ArrayList<>();
        countryrepos.findAll().iterator().forEachRemaining(myList::add);
        myList.sort((c1, c2) -> (int) (c1.getPopulation() + c2.getPopulation()));
        Country c = myList.get(myList.size() / 2);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

}
