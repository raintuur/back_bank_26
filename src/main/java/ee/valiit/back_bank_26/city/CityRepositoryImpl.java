package ee.valiit.back_bank_26.city;

import java.util.ArrayList;
import java.util.List;

public class CityRepositoryImpl implements CityRepository {

    public static List<City> cities = new ArrayList<>();

    @Override
    public void createCityRepository() {
        City city1 = new City(1,"Tallinn");
        City city2 = new City(2,"Tartu");
        City city3 = new City(3,"Pärnu");
        cities.add(city1);
        cities.add(city2);
        cities.add(city3);
    }

    @Override
    public List<City> findAllCities() {
        return cities;
    }

}
