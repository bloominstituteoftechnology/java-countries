package com.lambdaschool.countries.controllers;

import com.lambdaschool.countries.models.Country;

import java.util.ArrayList;
import java.util.List;


public class HelperFunctions
{

    public static List<Country> findCountries(List<Country> fullList, CheckCountry tester)
    {
        List<Country> tempCountry = new ArrayList<>();

        for (Country c : fullList)
        {
            if (tester.test(c))
            {
                tempCountry.add(c);
            }
        }

        return tempCountry;
    }
}
