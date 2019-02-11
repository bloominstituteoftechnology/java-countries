package app.webcountries.controllers;

import app.webcountries.WebCountriesApplication;
import app.webcountries.models.Country;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/age")
public class AgeController
{
    @RequestMapping("age")
    public ArrayList<Country> age(@RequestParam(value = "age") String n)
    {
        return WebCountriesApplication.countryResource.filter((e) -> e.getMedianAge() >= Integer.parseInt(n));
    }

    @RequestMapping("min")
    public Country min()
    {
        return WebCountriesApplication.countryResource.minAge();
    }

    @RequestMapping("max")
    public Country max()
    {
        return WebCountriesApplication.countryResource.maxAge();
    }

}
