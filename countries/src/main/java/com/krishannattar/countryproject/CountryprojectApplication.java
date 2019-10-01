package com.krishannattar.countryproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountryprojectApplication {

    static CountryList ourCountryList;

    public static void main(String[] args) {

        ourCountryList =new CountryList();
        SpringApplication.run(CountryprojectApplication.class, args);
    }

}
