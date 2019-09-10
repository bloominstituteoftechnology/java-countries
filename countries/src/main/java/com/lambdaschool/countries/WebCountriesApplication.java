package com.lambdaschool.countries;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebCountriesApplication
{
    static CountryList ourCountryList;

    public static void main(String[] args)
    {//object
        ourCountryList = new CountryList();
        SpringApplication.run(WebCountriesApplication.class, args);
    }
}
