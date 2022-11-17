package ee.valiit.back_bank_26.atm;

import ee.valiit.back_bank_26.CityInfo;
import ee.valiit.back_bank_26.city.City;
import ee.valiit.back_bank_26.city.CityMapperImpl;
import ee.valiit.back_bank_26.city.CityRepositoryImpl;
import ee.valiit.back_bank_26.location.LocationDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AtmController {

    @GetMapping("/atm/city")
    public List<CityInfo> getCitiesInfo() {
        CityRepositoryImpl cityRepository = new CityRepositoryImpl();
        List<City> cities = cityRepository.findAllCities();
        CityMapperImpl cityMapper = new CityMapperImpl();
        List<CityInfo> cityInfos = cityMapper.citiesToCityInfos(cities);
        return cityInfos;
    }

    @GetMapping("/atm/service")
    public List<AtmServiceInfo> getAtmServices() {
        AtmServiceRepositoryImpl atmServiceRepository = new AtmServiceRepositoryImpl();
        List<AtmService> atmServices = atmServiceRepository.getAllAtmServices();
        AtmMapperImpl atmMapper = new AtmMapperImpl();
        List<AtmServiceInfo> infos = atmMapper.AtmServicesToAtmServiceInfos(atmServices);
        return infos;
    }

    @GetMapping("/atm/info")
    public List<LocationDto> getAllAtmLocations() {

        List<LocationDto> result = new ArrayList<>();

        return result;
    }
}

