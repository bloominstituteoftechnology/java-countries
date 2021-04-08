package lambda.school.javacountries.controllers;

import lambda.school.javacountries.models.Countries;

@FunctionalInterface

public interface CountryCheck {
    boolean test(Countries countries);
}
