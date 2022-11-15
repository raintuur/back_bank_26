package ee.valiit.back_bank_26;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BackBank26Application {


	public static List<City> cities = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(BackBank26Application.class, args);
	}

	public static List<City> findAllCities() {
		return cities;
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