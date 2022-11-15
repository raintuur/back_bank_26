package ee.valiit.back_bank_26;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class BackBank26Application {

    public static List<City> cities = new ArrayList<>();
	public static List<AtmService> atmServices = new ArrayList<>();

    public static void main(String[] args) {
		createCityRepository();
		createAtmServices ();
        SpringApplication.run(BackBank26Application.class, args);
    }

	private static void createAtmServices() {
		Integer id= 1;
		String name = "Raha sisse";

		AtmService atmService1 = createAtmServices(id);

		System.out.println(atmService);
	}

	private static AtmService getAtmService(Integer id) {
		AtmService atmService = new AtmService();
		atmService.setId(id);
		atmService.setName("name");
		return atmService;
	}

	public static List<City> findAllCities() {
		return cities;
	}

	private static void createCityRepository() {
		City city1 = new City(1,"Tallinn");
		City city2 = new City(2,"Tartu");
		City city3 = new City(3,"Pärnu");
		cities.add(city1);
		cities.add(city2);
		cities.add(city3);
	}

}
