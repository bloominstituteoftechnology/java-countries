package lambda.school.javacountries.controllers;

import lambda.school.javacountries.model.Country;

@FunctionalInterface
public interface QueryCountries {
  boolean test(Country country);
}
