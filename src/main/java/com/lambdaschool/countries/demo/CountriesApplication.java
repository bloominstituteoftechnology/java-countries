package com.lambdaschool.countries.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountriesApplication {
    static CountryList countryList;
    public static void main(String[] args) {
        countryList = new CountryList;
        SpringApplication.run(CountriesApplication.class, args);
    }
}

