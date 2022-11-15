package ee.valiit.back_bank_26;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class BackBank26Application {

    public static List<City> cities = new ArrayList<>();

    public static List<AtmService> atmServices = new ArrayList<>();


    public static void main(String[] args) {
        createCityRepository();
        createAtmServices(1, "Raha sisse");
        SpringApplication.run(BackBank26Application.class, args);
    }

    private static AtmService createAtmServices(int i, String raha_sisse) {
        Integer id = 1;
        String name = "Raha sisse";

        AtmService atmService1 = createAtmServices(1, "Raha sisse");
        AtmService atmService2 = createAtmServices(2, "Raha välja");
        AtmService atmService3 = createAtmServices(3, "Maksed");
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

    public static List<City> findAllCities() {
        return cities;
    }

    private static void createCityRepository() {
        City city1 = new City("Tallinn", 1);
        City city2 = new City("Tartu", 2);
        City city3 = new City("Narva", 3);
        cities.add(city1);
        cities.add(city2);
        cities.add(city3);


    }

}
