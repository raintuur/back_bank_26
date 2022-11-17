package ee.valiit.back_bank_26;

import ee.valiit.back_bank_26.atm.AtmServiceRepositoryImpl;
import ee.valiit.back_bank_26.city.CityRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackBank26Application {

    public static void main(String[] args) {
        CityRepositoryImpl cityRepository = new CityRepositoryImpl();
        cityRepository.createCityRepository();

        AtmServiceRepositoryImpl atmServiceRepository = new AtmServiceRepositoryImpl();
        atmServiceRepository.createAtmServices();

        SpringApplication.run(BackBank26Application.class, args);
    }

}
