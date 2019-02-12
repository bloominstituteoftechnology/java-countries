package com.example.countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountriesApplication {

    static CountryList ourCountryList;
    public static void main(String[] args)
    {
        ourCountryList = new CountryList();
        SpringApplication.run(CountriesApplication.class, args);

    }
}


