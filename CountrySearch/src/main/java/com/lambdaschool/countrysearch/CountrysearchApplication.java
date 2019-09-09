package com.lambdaschool.countrysearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountrysearchApplication {

    static CountryList ourCountryList;
    public static void main(String[] args)
    {
        ourCountryList = new CountryList();
        SpringApplication.run(CountrysearchApplication.class, args);
    }

}
