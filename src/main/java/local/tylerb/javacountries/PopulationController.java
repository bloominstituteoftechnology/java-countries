package local.tylerb.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.OutputKeys;
import java.util.ArrayList;

@RestController
@RequestMapping("population")
public class PopulationController {

    @GetMapping("/size/{people}")
    public ResponseEntity<?> getCountryByPopulationSize(@PathVariable long people) {
        ArrayList<Country> popList = JavaCountriesApplication.list.findCountries(e -> e.getPopulation() >= people);
        return new ResponseEntity<>(popList, HttpStatus.OK);
    }

    @GetMapping("/min")
    public ResponseEntity<?> getSmallPop() {
        JavaCountriesApplication.list.countryList.sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()));
        return new ResponseEntity<>(JavaCountriesApplication.list.countryList.get(0), HttpStatus.OK);
    }

    @GetMapping("/max")
    public ResponseEntity<?> getLargePop() {
        JavaCountriesApplication.list.countryList.sort((c1, c2) -> (int)(c2.getPopulation() - c1.getPopulation()));
        return new ResponseEntity<>(JavaCountriesApplication.list.countryList.get(0), HttpStatus.OK);
    }


}
