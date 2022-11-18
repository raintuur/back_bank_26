package ee.valiit.back_bank_26.atm;

import ee.valiit.back_bank_26.atm.option.Option;
import ee.valiit.back_bank_26.atm.option.OptionDto;
import ee.valiit.back_bank_26.atm.option.OptionMapper;
import ee.valiit.back_bank_26.atm.option.OptionRepository;
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
    private OptionRepository optionRepository;

    @Resource
    private CityMapper cityMapper;

    @Resource
    private OptionMapper optionMapper;


    @GetMapping("/atm/city")
    public List<CityDto> getAllCities() {
        List<City> allEntities = cityRepository.findAll();
        List<CityDto> cityDtos = cityMapper.citiesToCityDtos(allEntities);
        return cityDtos;
    }

    @GetMapping("/atm/option")
    public List<OptionDto> getAllAtmOptions() {
        List<Option> entities = optionRepository.findAll();
        List<OptionDto> optionDtos = optionMapper.toDtos(entities);
        return optionDtos;
    }

//    @GetMapping("/atm/info")


}
