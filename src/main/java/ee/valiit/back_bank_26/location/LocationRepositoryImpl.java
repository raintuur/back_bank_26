package ee.valiit.back_bank_26.location;

import ee.valiit.back_bank_26.city.City;
import ee.valiit.back_bank_26.city.CityRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class LocationRepositoryImpl implements LocationRepository{

    private static List<Location> locations = new ArrayList<>(); 
    
    @Override
    public void createLocationRepository() {
        Location location1 = createLocation("Tondi Selver", 1, "Tallinn");
        Location location2 = createLocation("Järve Selver", 2, "Tallinn");
        Location location3 = createLocation("Jõe Prisma", 3, "Tartu");
        Location location4 = createLocation("Port Artur", 4, "Pärnu");
        locations.add(location1);
        locations.add(location2);
        locations.add(location3);
        locations.add(location4);
    }

     public static Location createLocation(String locationName, int locationId, String cityName) {
        CityRepositoryImpl cityRepository = new CityRepositoryImpl();
        City city = cityRepository.getCityByName(cityName);

        Location location = new Location();
        location.setId(locationId);
        location.setCity(city);
        location.setName(locationName);
        location.setStatus('A');
        return location;
    }
}
