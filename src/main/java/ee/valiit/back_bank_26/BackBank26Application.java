package ee.valiit.back_bank_26;

import ee.valiit.back_bank_26.atm.AtmService;
import ee.valiit.back_bank_26.atm.AtmServiceRepositoryImpl;
import ee.valiit.back_bank_26.city.City;
import ee.valiit.back_bank_26.city.CityRepository;
import ee.valiit.back_bank_26.city.CityRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BackBank26Application {


	public static List<AtmService> atmServices = new ArrayList<>();
	public static List<Location> locations = new ArrayList<>();

	public static void main(String[] args) {
		CityRepositoryImpl cityRepository = new CityRepositoryImpl();
		cityRepository.createCityRepository();
		AtmServiceRepositoryImpl atmServiceRepository = new AtmServiceRepositoryImpl();
		atmServiceRepository.createAtmServiceRepository();

		SpringApplication.run(BackBank26Application.class, args);
	}

}
