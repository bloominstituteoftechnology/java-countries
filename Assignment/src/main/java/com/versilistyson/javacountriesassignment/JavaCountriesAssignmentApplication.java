package com.versilistyson.javacountriesassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaCountriesAssignmentApplication {
    static CountryList myCountryList;
    public static void main(String[] args) {
        myCountryList = new CountryList();
        SpringApplication.run(JavaCountriesAssignmentApplication.class, args);
    }

}
