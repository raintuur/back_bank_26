package ee.valiit.back_bank_26;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BackBank26Application {


    public static List<City> cities = new ArrayList<>();
    public static List<AtmService> atmServices = new ArrayList<>();


    public static List<City> findAllCities() {
        return cities;
    }

    public static void main(String[] args) {
        createCityRepository();
        createAtmCervices();
        SpringApplication.run(BackBank26Application.class, args);
    }

    private static void createAtmCervices() {
        AtmService atmService1 = createAtmService(1, "Raha sisse");
        AtmService atmService2 = createAtmService(2, "Raha välja");
        AtmService atmService3 = createAtmService(3, "Maksed");
        atmServices.add(atmService1);
        atmServices.add(atmService2);
        atmServices.add(atmService3);

    }

    private static void createAtmService(Integer id, String name) {
        AtmService atmService = new AtmService();
        atmService.setId(id);
        atmService.setName(name);
        return atmService;
    }


    private static void createCityRepository() {
        City city1 = new City("Tallinn", 1);
        City city2 = new City("Tartu", 2);
        City city3 = new City("Pärnu", 3);
        cities.add(city1);
        cities.add(city2);
        cities.add(city3);

    }


}