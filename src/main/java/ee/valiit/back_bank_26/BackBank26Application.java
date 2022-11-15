package ee.valiit.back_bank_26;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class BackBank26Application {

    public static List<City> cities = new ArrayList<>();

    public static List<AtmServiceInfo> atmServices = new ArrayList<>();


    public static void main(String[] args) {
        createCityRepository();
        createAtmServices(1, "Raha sisse");
        SpringApplication.run(BackBank26Application.class, args);
    }

    private static AtmServiceInfo createAtmServices(int i, String raha_sisse) {
        Integer id = 1;
        String name = "Raha sisse";

        AtmServiceInfo atmService1 = createAtmServices(1, "Raha sisse");
        AtmServiceInfo atmService2 = createAtmServices(2, "Raha välja");
        AtmServiceInfo atmService3 = createAtmServices(3, "Maksed");
        atmServices.add(atmService1);
        atmServices.add(atmService2);
        atmServices.add(atmService3);
        return atmService1;
    }

    private static AtmServiceInfo createAtmService(Integer id, String name) {
        AtmServiceInfo atmService = new AtmServiceInfo();
        atmService.setId(id);
        atmService.setName(name);
        return atmService;
    }

    public static List<City> findAllCities() {
        return cities;
    }
    public static List<AtmServiceInfo> findAllAtmServices (){
        return atmServices;
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
