package com.lambdaschool.com.countries.controllers;

import com.lambdaschool.com.countries.models.CountryInfo;

import java.util.ArrayList;
import java.util.List;

public class ExtraFunctions
{

    public static List<CountryInfo> findCountries(List<CountryInfo> fullList, CheckCountry tester)
    {
        List<CountryInfo> tempCountry = new ArrayList<>();

        for (CountryInfo c : fullList)
        {
            if (tester.test(c))
            {
                tempCountry.add(c);
            }
        }

        return tempCountry;
    }
}