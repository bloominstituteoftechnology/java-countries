package lambda.school.demo.controllers;

import lambda.school.demo.models.Country;

@FunctionalInterface
public interface CheckCountries
{
    boolean test(Country country);
}
