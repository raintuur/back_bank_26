package ee.valiit.back_bank_26.location;

import ee.valiit.back_bank_26.city.City;
import ee.valiit.back_bank_26.city.CityRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class LocationRepositoryImpl implements LocationRepository {

    private static List<Location> locations = new ArrayList<>();

    @Override
    public void createLocationRepository() {
        int id = 1;
        Location location;

        location = createLocation("Tondi Selver", id, "Tallinn");
        locations.add(location);
        id++;


        location = createLocation("Järve Selver", id, "Tallinn");
        locations.add(location);
        id++;

        location = createLocation("Jõe Prisma", id, "Tartu");
        locations.add(location);
        id++;

    }

    private static Location createLocation(String locationName, int locationId, String cityName) {
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
