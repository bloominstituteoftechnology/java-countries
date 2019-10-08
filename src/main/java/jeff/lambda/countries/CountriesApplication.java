package jeff.lambda.countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountriesApplication
{
    static CountryList ourCountryList = new CountryList();

    public static void main(String[] args)
    {
        SpringApplication.run(CountriesApplication.class, args);
    }

}
