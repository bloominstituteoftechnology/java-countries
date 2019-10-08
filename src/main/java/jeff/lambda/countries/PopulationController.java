package jeff.lambda.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class PopulationController
{
    // /population/size/{people}
    @GetMapping(value = "/size/{population}", produces = {"application/json"})
    public ResponseEntity<?> getCountryByPopulation(@PathVariable int population)
    {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList.findCountries(c -> c.getPopulation() >= population);
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    // /population/min
    @GetMapping(value = "/min", produces = {"application/json"})
    public ResponseEntity<?> getCountryByLowestPopulation()
    {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList.countryList;
        rtnCountries.sort((c1, c2) -> (c1.getPopulation() - c2.getPopulation()));
        return new ResponseEntity<>(rtnCountries.get(0), HttpStatus.OK);
    }

    // /population/max
    @GetMapping(value = "/max", produces = {"application/json"})
    public ResponseEntity<?> getCountryByHighestPopulation()
    {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList.countryList;
        rtnCountries.sort((c1, c2) -> (c1.getPopulation() - c2.getPopulation()));
        return new ResponseEntity<>(rtnCountries.get(rtnCountries.size() - 1), HttpStatus.OK);
    }

}
