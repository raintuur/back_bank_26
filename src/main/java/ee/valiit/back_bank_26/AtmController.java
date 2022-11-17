package ee.valiit.back_bank_26;

import ee.valiit.back_bank_26.city.City;
import ee.valiit.back_bank_26.city.CityDto;
import ee.valiit.back_bank_26.city.CityMapper;
import ee.valiit.back_bank_26.city.CityRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AtmController {

    @Resource
    private CityRepository cityRepository;

    @Resource
    private CityMapper cityMapper;

    @GetMapping("/atm/city")
    public List<CityDto> getAllCities() {

        List<CityDto> cities = new ArrayList<>();
//        for (City city : cityRepository.findAll()) {
//                cities.add(cityMapper.cityToCityDto(city));
//        }

        cityRepository.findAll().forEach(city -> cities.add(cityMapper.cityToCityDto(city)));
        return cities;

//        return cities;


    }

    @GetMapping("/atm/service")
    public String getAtmServiceInfo() {


        return null;
    }

    @GetMapping("/atm/info")
    public String getAtmLocationByName() {
        return null;
    }
}

