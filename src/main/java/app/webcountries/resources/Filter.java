package app.webcountries.resources;

import app.webcountries.models.Country;

public interface Filter
{
    boolean  filter(Country e);
}
