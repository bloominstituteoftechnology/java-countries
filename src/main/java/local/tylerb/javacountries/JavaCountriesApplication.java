package local.tylerb.javacountries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaCountriesApplication {

    static CountryList list;
    public static void main(String[] args) {
        list = new CountryList();
        SpringApplication.run(JavaCountriesApplication.class, args);
    }

}
