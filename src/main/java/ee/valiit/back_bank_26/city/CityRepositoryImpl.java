package ee.valiit.back_bank_26.city;

import java.util.ArrayList;
import java.util.List;

public class CityRepositoryImpl implements CityRepository {

    public static List<City> cities = new ArrayList<>();

    @Override
    public void createCityRepository() {
        List<City> result = new ArrayList<>();
        City city1 = new City("Tallinn", 1);
        City city2 = new City("Tartu", 2);
        City city3 = new City("Pärnu", 3);
        cities.add(city1);
        cities.add(city2);
        cities.add(city3);
    }

    @Override
    public List<City> findAllCities() {
        return cities;
    }

    @Override
    public City getCityByName(String name) {

        for (City city : cities) {
            if (city.getName().equals(name)) {
                return city;
            }
        }
        return null;
    }

}
