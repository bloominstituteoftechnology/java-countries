package lambda.school.countries.controllers;

import lambda.school.countries.models.Country;

@FunctionalInterface
public interface CheckCountries {
    boolean test(Country country);
}
