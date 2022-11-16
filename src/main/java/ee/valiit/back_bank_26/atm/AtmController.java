package ee.valiit.back_bank_26.atm;

import ee.valiit.back_bank_26.BackBank26Application;
import ee.valiit.back_bank_26.city.CityDto;
import ee.valiit.back_bank_26.city.City;
import ee.valiit.back_bank_26.city.CityMapperImpl;
import ee.valiit.back_bank_26.city.CityRepositoryImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AtmController {

    @GetMapping("/atm/city")
    public List<CityDto> getCitiesInfo() {
        CityRepositoryImpl cityRepository = new CityRepositoryImpl();
        List<City> cities = cityRepository.findAllCities();
        CityMapperImpl cityMapper = new CityMapperImpl();

        return cityMapper.citiesToCitiesDto(cities);
    }

    @GetMapping("/atm/service")
    public List<AtmServiceDto> getAtmServiceInfo() {
        AtmServiceRepositoryImpl atmServiceRepository = new AtmServiceRepositoryImpl();
        List<AtmService> serviceList = atmServiceRepository.findAllAtmServices();
        AtmServiceMapperImpl atmServiceMapper = new AtmServiceMapperImpl();

        return atmServiceMapper.atmServicesToAtmServicesDto(serviceList);
    }

    @GetMapping("/atm/info")
    public void getAtmLocationByName() {

    }
}

