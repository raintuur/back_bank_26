package ee.valiit.back_bank_26.atm;

import ee.valiit.back_bank_26.atm.option.AtmService;
import ee.valiit.back_bank_26.atm.option.AtmServiceDto;
import ee.valiit.back_bank_26.atm.option.AtmServiceMapper;
import ee.valiit.back_bank_26.atm.option.AtmServiceRepository;
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
    private AtmServiceRepository atmServiceRepository;

    @Resource
    private AtmServiceMapper atmServiceMapper;


    @GetMapping("/atm/city")
    public List<CityDto> getAllCities() {
        List<City> allEntities = cityRepository.findAll();
        List<CityDto> allDtos = cityMapper.citiesToCityDtos(allEntities);
        return allDtos;
    }

    @GetMapping("/atm/service")
    public List<AtmServiceDto> getAllAtmOptions() {
        List<AtmService> entities = atmServiceRepository.findAll();
        List<AtmServiceDto> dtos = atmServiceMapper.toDtos(entities);
        return dtos;
    }
//
//    @GetMapping("/atm/info")
}
