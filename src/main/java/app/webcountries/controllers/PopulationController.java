package app.webcountries.controllers;

import app.webcountries.WebCountriesApplication;
import app.webcountries.models.Country;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class PopulationController
{
    @RequestMapping("size")
    public ArrayList<Country> size(@RequestParam(value = "people") String people)
    {
        return WebCountriesApplication.countryResource.filter((e) -> e.getPopulation() >= Integer.parseInt(people));
    }

    @RequestMapping("min")
    public Country min()
    {

        return WebCountriesApplication.countryResource.minPopulation();
    }

    @RequestMapping("max")
    public Country max()
    {

        return WebCountriesApplication.countryResource.maxPopulation();
    }

}
