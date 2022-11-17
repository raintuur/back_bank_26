package ee.valiit.back_bank_26.atm;

import ee.valiit.back_bank_26.atm.option.AtmOption;
import ee.valiit.back_bank_26.atm.option.AtmOptionDto;
import ee.valiit.back_bank_26.atm.option.AtmOptionMapper;
import ee.valiit.back_bank_26.atm.option.AtmOptionRepository;
import ee.valiit.back_bank_26.city.City;
import ee.valiit.back_bank_26.city.CityDto;
import ee.valiit.back_bank_26.city.CityMapper;
import ee.valiit.back_bank_26.city.CityRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class AtmController {

    @Resource
    private CityRepository cityRepository;

    @Resource
    private CityMapper cityMapper;

    @Resource
    private AtmOptionRepository atmOptionRepository;

    @Resource
    private AtmOptionMapper atmOptionMapper;

    @GetMapping("/atm/city")
    public List<CityDto> getAllCities() {
        List<City> allEntities = cityRepository.findAll();
        List<CityDto> allDtos = cityMapper.citiesToCityDtos(allEntities);
        return allDtos;
    }

    @GetMapping("/atm/service")
    public List<AtmOptionDto> getAllAtmOptions() {
        List<AtmOption> entities = atmOptionRepository.findAll();
        List<AtmOptionDto> dTos = atmOptionMapper.toDtos(entities);
        return dTos;
    }


//    @GetMapping("/atm/info")

}

