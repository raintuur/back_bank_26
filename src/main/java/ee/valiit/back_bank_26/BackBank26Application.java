package ee.valiit.back_bank_26;

import ee.valiit.back_bank_26.atm.AtmService;
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
        createAtmServices();
        createLocationRepository();
        CityRepositoryImpl cityRepository = new CityRepositoryImpl();
        cityRepository.createCityRepository();
    }

    public static List<AtmService> findAllAtmServices() {
        return atmServices;
    }

    public static List<Location> locations;

    private static void createAtmServices() {

        AtmService atmService1 = createAtmService(1, "Raha sisse");
        AtmService atmService2 = createAtmService(2, "Raha välja");
        AtmService atmService3 = createAtmService(3, "Maksed");
        atmServices.add(atmService1);
        atmServices.add(atmService2);
        atmServices.add(atmService3);
    }

    private static AtmService createAtmService(Integer id, String name) {
        AtmService atmService = new AtmService();
        atmService.setId(id);
        atmService.setName(name);
        return atmService;
    }

    private static void createLocationRepository() {
        Location location = new Location();
        location.setId(1);
        location.setName("Tondi Selver");
        location.setStatus('A');
//        location.setCity();
    }
}