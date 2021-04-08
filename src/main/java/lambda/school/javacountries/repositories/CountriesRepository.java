package lambda.school.javacountries.repositories;

import lambda.school.javacountries.models.Countries;
import org.springframework.data.repository.CrudRepository;

public interface CountriesRepository extends CrudRepository<Countries, Long> {
}
