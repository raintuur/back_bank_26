package ee.valiit.back_bank_26.atm;

import ee.valiit.back_bank_26.atm.option.AtmServiceDto;
import ee.valiit.back_bank_26.atm.option.AtmServiceMapper;
import ee.valiit.back_bank_26.atm.option.AtmServiceRepository;
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
        return cityMapper.citiesTocityDtos(cityRepository.findAll());
    }

    @GetMapping("/atm/service")
    public List<AtmServiceDto> getAllOptions() {
        return atmServiceMapper.toDtos(atmServiceRepository.findAll());
    }

    @GetMapping("/atm/info")
    public String getAtmLocationByName() {
        return null;
    }
}

