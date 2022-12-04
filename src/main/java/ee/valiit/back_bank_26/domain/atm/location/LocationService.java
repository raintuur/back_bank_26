package ee.valiit.back_bank_26.domain.atm.location;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LocationService {

    @Resource
    private LocationRepository locationRepository;

    public List<Location> findAll() {
        List<Location> locations = locationRepository.findAll();
        return locations;
    }

    public List<Location> findLocationsBy(Integer cityId) {
        List<Location> locations = locationRepository.findLocationsBy(cityId);
        return locations;
    }

    public Location findById(Integer locationId) {
        Location location = locationRepository.findById(locationId).get();
        return location;
    }
}
