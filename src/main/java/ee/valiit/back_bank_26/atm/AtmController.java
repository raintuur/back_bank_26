package ee.valiit.back_bank_26.atm;

import ee.valiit.back_bank_26.atm.location.Location;
import ee.valiit.back_bank_26.atm.location.LocationDto;
import ee.valiit.back_bank_26.atm.location.LocationMapper;
import ee.valiit.back_bank_26.atm.location.LocationRepository;
import ee.valiit.back_bank_26.atm.option.Option;
import ee.valiit.back_bank_26.atm.option.OptionDto;
import ee.valiit.back_bank_26.atm.option.OptionMapper;
import ee.valiit.back_bank_26.atm.option.OptionRepository;
import ee.valiit.back_bank_26.city.City;
import ee.valiit.back_bank_26.city.CityDto;
import ee.valiit.back_bank_26.city.CityMapper;
import ee.valiit.back_bank_26.city.CityRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/atm")
public class AtmController {

    @Resource
    private CityRepository cityRepository;

    @Resource
    private OptionRepository optionRepository;

    @Resource
    private LocationRepository locationRepository;

    @Resource
    private CityMapper cityMapper;

    @Resource
    private OptionMapper optionMapper;

    @Resource
    private LocationMapper locationMapper;






    @GetMapping("/city")
    @Operation(summary = "Selle teenusega saad kätte kõik linnad", description = "Mingi pikem jutt rohkem mula")
    public List<CityDto> getAllCities() {
        List<City> allEntities = cityRepository.findAll();
        List<CityDto> allDtos = cityMapper.citiesToCityDtos(allEntities);
        return allDtos;
    }


    @GetMapping("/option")
    @Operation(summary = "Leiab kõik automaatide võimalikud valikud (sularaha välja, sulraha sisse, jne)")
    public List<OptionDto> getAllAtmOptions() {
        List<Option> entities = optionRepository.findAll();
        List<OptionDto> optionDtos = optionMapper.toDtos(entities);
        return optionDtos;
    }
//
    @GetMapping("/info")
    @Operation( summary = "Leiab kõikide pangaautomaatide asukohad")
    public LocationDto getAllAtmLocations() {
        Location location = locationRepository.getById(1);
        LocationDto locationDto = locationMapper.toDto(location);


        return locationDto;
    }
}
