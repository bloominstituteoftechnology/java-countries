package com.example.countriesflex.services;

import com.example.countriesflex.models.Country;
import com.example.countriesflex.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "countryService")
public class CountryServiceImpl implements CountryService{
@Autowired
    CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries() {
        List<Country> returnList = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining((c) -> returnList.add(c));
        return returnList;
    }

    @Override
    public List<Country> countriesByLetter(char letter) {
        return null;
    }

    @Override
    public long getPopulationTotal() {
        List<Country> countryList = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining((c) -> countryList.add(c));
        long total = 0;
        for (Country c : countryList) {
            total += c.getPopulation();
        }
        return total;
    }

    @Override
    public Country getMinPopulation() {
        return null;
    }

    @Override
    public Country getMaxPopulation() {
        return null;
    }
}
