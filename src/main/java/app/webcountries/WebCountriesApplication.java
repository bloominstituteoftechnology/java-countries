package app.webcountries;

import app.webcountries.resources.CountryResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebCountriesApplication
{
    public static CountryResource countryResource;
    public static void main(String[] args)
    {

        countryResource = new CountryResource();
        SpringApplication.run(WebCountriesApplication.class, args);
    }

}

