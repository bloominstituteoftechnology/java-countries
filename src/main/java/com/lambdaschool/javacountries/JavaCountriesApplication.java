package com.lambdaschool.javacountries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaCountriesApplication {

    public static CountriesArrayList listcountry;
    public static void main(String[] args)
    {

        listcountry = new CountriesArrayList();


        SpringApplication.run(JavaCountriesApplication.class, args);
    }

}

