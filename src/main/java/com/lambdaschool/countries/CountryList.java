package com.lambdaschool.countries;

import java.util.ArrayList;

// Create an array list for country objects
//        * Each country object will contain
//        * a country name, population, land mass size, and median age
//        * should contain the standard getter and setters

public class CountryList
{
    // my ArrayList of countries
    public ArrayList<Country> countryList = new ArrayList<Country>();

    public CountryList()
    {
        countryList.add(new Country("China", 1420062022, 9388211, 39));
        countryList.add(new Country("India", 1368737513, 2973190, 28));
        countryList.add(new Country("U.S.", 329093110, 9147420, 38));
    }

    public Country findCountry(CheckCountry tester)
    {
        for (Country c : countryList) // if country is found, return country
        {
            if (tester.test(c))
            {
                return c;
            }
        }
        return null; // if no countries are found, return null
    }
}
