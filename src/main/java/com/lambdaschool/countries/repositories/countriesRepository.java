package com.lambdaschool.countries.repositories;

import com.lambdaschool.countries.models.countries;
import org.springframework.data.repository.CrudRepository;

public interface countriesRepository extends CrudRepository<countries, Long> {
}
