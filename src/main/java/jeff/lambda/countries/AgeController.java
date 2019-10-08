package jeff.lambda.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;

@RestController
@RequestMapping("/age")
public class AgeController
{
    // /age/{age}
    @GetMapping(value ="/{age}", produces ={"application/json"})
    public ResponseEntity<?> getCountryByMedianAgeOrGreater(@PathVariable int age)
    {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList.findCountries(c -> c.getMedianAge() >= age);
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    // /age/max
    @GetMapping(value = "/max", produces = {"application/json"})
    public ResponseEntity<?> getCountryByHighestMedianAge()
    {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList.countryList;
        rtnCountries.sort((c1, c2) -> (c1.getMedianAge() - c2.getMedianAge()));
        return new ResponseEntity<>(rtnCountries.get(rtnCountries.size() - 1), HttpStatus.OK);
    }

    // /age/min
    @GetMapping(value = "/min", produces = {"application/json"})
    public ResponseEntity<?> getCountryByLowestMedianAge()
    {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList.countryList;
        rtnCountries.sort(Comparator.comparingInt(Country::getMedianAge));
        return new ResponseEntity<>(rtnCountries.get(0), HttpStatus.OK);
    }

}
