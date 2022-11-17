package ee.valiit.back_bank_26.location;

import ee.valiit.back_bank_26.atm.AtmService;
import ee.valiit.back_bank_26.city.City;
import ee.valiit.back_bank_26.city.CityRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class AtmLocationRepositoryImpl implements AtmLocationRepository {

    private static List<Location> locations = new ArrayList<>();


    @Override
    public void createAtmLocationRepository() {
        CityRepositoryImpl cr = new CityRepositoryImpl();

        Location location1 = new Location(1, cr.getCityByName("Tallinn"), "Tondi Selver", 'A');
        Location location2 = new Location(2, cr.getCityByName("Tallinn"), "Järve Selver", 'A');
        Location location3 = new Location(3, cr.getCityByName("Tartu"), "Veeriku Selver", 'A');
        Location location4 = new Location(4, cr.getCityByName("Viljandi"), "Uku Keskus", 'A');

        locations.add(location1);
        locations.add(location2);
        locations.add(location3);
        locations.add(location4);
    }

    @Override
    public List<Location> findAllAtmLocations() {
        return locations;
    }
}
