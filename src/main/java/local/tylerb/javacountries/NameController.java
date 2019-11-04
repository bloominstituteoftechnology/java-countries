package local.tylerb.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class NameController {

    @GetMapping(value = "/all",
                produces = {"application/json"})
    public ResponseEntity<?> getAllCountries() {
        JavaCountriesApplication.list.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(JavaCountriesApplication.list.countryList, HttpStatus.OK);
    }

    @GetMapping(value = "/start/{letter}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryNameByLetter(@PathVariable char letter) {
        ArrayList<Country> rtnCountryByName = JavaCountriesApplication.list.findCountries(c -> c.getName().charAt(0) == letter);
        rtnCountryByName.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountryByName, HttpStatus.OK);
    }

    @GetMapping(value = "/size/{number}",
            produces = {"application/json"})
    public ResponseEntity<?> getCountryNameBySize(@PathVariable long number) {
        ArrayList<Country> rtnCountryByName = JavaCountriesApplication.list.findCountries(c -> c.getName().length() >= number);
        rtnCountryByName.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountryByName, HttpStatus.OK);
    }


}
