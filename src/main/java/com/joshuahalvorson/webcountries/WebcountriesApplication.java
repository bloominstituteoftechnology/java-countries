package com.joshuahalvorson.webcountries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebcountriesApplication {

    static CountriesList countriesList;
    public static void main(String[] args) {
        countriesList = new CountriesList();
        SpringApplication.run(WebcountriesApplication.class, args);
    }

}

