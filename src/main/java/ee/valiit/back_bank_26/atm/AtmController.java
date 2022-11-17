package ee.valiit.back_bank_26.atm;

import ee.valiit.back_bank_26.city.City;
import ee.valiit.back_bank_26.city.CityDto;
import ee.valiit.back_bank_26.city.CityMapper;
import ee.valiit.back_bank_26.city.CityRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
public class AtmController {

    @Resource
    private CityRepository cityRepository;

    @Resource
    private CityMapper cityMapper;

    @GetMapping("/atm/city")
    public CityDto getAllCities() {
        List<City> all = cityRepository.findAll();

        City tallinn = cityRepository.getById(1);
        CityDto tallinnDto = cityMapper.cityToCityDto(tallinn);

        return tallinnDto;
    }

//    @GetMapping("/atm/service")
//
//
//    @GetMapping("/atm/info")



}
