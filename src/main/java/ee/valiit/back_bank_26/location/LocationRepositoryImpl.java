package ee.valiit.back_bank_26.location;

import ee.valiit.back_bank_26.city.City;
import ee.valiit.back_bank_26.city.CityRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class LocationRepositoryImpl implements LocationRepository{

    private static List<Location> locations = new ArrayList<>(); 
    
    @Override
    public void createLocationRepository() {

        String cityName = "Tallinn";
        int locationId = 1;
        String locationName = "Tondi Selver";

        createLocation(cityName, locationId, locationName);
    }

    private static void createLocation(String cityName, int locationId, String locationName) {
        CityRepositoryImpl cityRepository = new CityRepositoryImpl();
        City city = cityRepository.getCityByName(cityName);
        Location location = new Location();
        location.setId(locationId);
        location.setCity(city);
        location.setName(locationName);
        location.setStatus('A');
    }
}
