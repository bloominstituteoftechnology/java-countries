package com.lambdaschool.countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountriesApplication {

    public static CL ourCountryList;

    public static void main(String[] args) {
        ourCountryList= new CL();
        SpringApplication.run(CountriesApplication.class, args);
    }

}
