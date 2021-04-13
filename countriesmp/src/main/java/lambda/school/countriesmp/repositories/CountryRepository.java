package lambda.school.countriesmp.repositories;

import lambda.school.countriesmp.models.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository <Country, Long> {
}
