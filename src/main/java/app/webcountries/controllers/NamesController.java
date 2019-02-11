package app.webcountries.controllers;
import app.webcountries.WebCountriesApplication;
import app.webcountries.models.Country;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class NamesController
{
    @RequestMapping("/all")
    public ArrayList<Country> all()
    {
        WebCountriesApplication.countryResource.countryList.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));

        return WebCountriesApplication.countryResource.countryList;
    }

    @RequestMapping("/begin")
    public ArrayList<Country> begin(@RequestParam(value = "letter") String letter)
    {

        return WebCountriesApplication.countryResource.filter((e) -> e.getName().toLowerCase().startsWith(letter.toLowerCase()));
    }

    @RequestMapping("/size")
    public ArrayList<Country> size(@RequestParam(value = "letters") String str)
    {
        WebCountriesApplication.countryResource.countryList.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        return WebCountriesApplication.countryResource.filter((e) -> e.getName().length() >= str.length());
    }


}
