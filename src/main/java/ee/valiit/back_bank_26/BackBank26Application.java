package ee.valiit.back_bank_26;

import ee.valiit.back_bank_26.atm.AtmService;
import ee.valiit.back_bank_26.atm.AtmServiceRepositoryImpl;
import ee.valiit.back_bank_26.city.City;
import ee.valiit.back_bank_26.city.CityRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BackBank26Application {
    public static List<City> cities;

    private static final List<AtmService> atmServices = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(BackBank26Application.class, args);
        createLocationRepository();

        AtmServiceRepositoryImpl atmServiceRepository = new AtmServiceRepositoryImpl();
        atmServiceRepository.createAtmServices();

        CityRepositoryImpl cityRepository = new CityRepositoryImpl();
        cityRepository.createCityRepository();
    }

    public static List<AtmService> findAllAtmServices() {
        return atmServices;
    }

    public static List<Location> locations;

    private static void createLocationRepository() {
        Location location = new Location();
        location.setId(1);
        location.setName("Tondi Selver");
        location.setStatus('A');
//        location.setCity();
    }
}