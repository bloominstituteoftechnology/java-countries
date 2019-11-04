package local.tylerb.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/age")
public class AgeController {

    @GetMapping(value = "/age/{age}")
    public ResponseEntity<?> getCountriesByAge(@PathVariable long age) {
        ArrayList<Country> rtnAgeList = JavaCountriesApplication.list.findCountries(c -> c.getAge() >= age);
        return new ResponseEntity<>(rtnAgeList, HttpStatus.OK);
    }

    @GetMapping("/min")
    public ResponseEntity<?> getSmallPop() {
        JavaCountriesApplication.list.countryList.sort((c1, c2) -> (int)(c1.getAge() - c2.getAge()));
        return new ResponseEntity<>(JavaCountriesApplication.list.countryList.get(0), HttpStatus.OK);
    }

    @GetMapping("/max")
    public ResponseEntity<?> getLargePop() {
        JavaCountriesApplication.list.countryList.sort((c1, c2) -> (int)(c2.getAge() - c1.getAge()));
        return new ResponseEntity<>(JavaCountriesApplication.list.countryList.get(0), HttpStatus.OK);
    }

    @GetMapping("/median")
    public ResponseEntity<?> getMiddleAge() {
        int middle;
        int listSize = JavaCountriesApplication.list.countryList.size() - 1;
        if (listSize % 2 == 0) {
            middle = listSize / 2;
        } else {
            middle = ((listSize + 1) / 2);
        }
        JavaCountriesApplication.list.countryList.sort((c1, c2) -> (int)(c1.getAge() - c2.getAge()));
        return new ResponseEntity<>(JavaCountriesApplication.list.countryList.get(middle), HttpStatus.OK);
    }



}
