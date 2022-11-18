package ee.valiit.back_bank_26.atm;

import ee.valiit.back_bank_26.domain.atm.atmoption.AtmOption;
import ee.valiit.back_bank_26.domain.atm.atmoption.AtmOptionMapper;
import ee.valiit.back_bank_26.domain.atm.atmoption.AtmOptionRepository;
import ee.valiit.back_bank_26.domain.atm.location.Location;
import ee.valiit.back_bank_26.domain.atm.location.LocationDto;
import ee.valiit.back_bank_26.domain.atm.location.LocationMapper;
import ee.valiit.back_bank_26.domain.atm.location.LocationRepository;
import ee.valiit.back_bank_26.domain.atm.option.Option;
import ee.valiit.back_bank_26.domain.atm.option.OptionDto;
import ee.valiit.back_bank_26.domain.atm.option.OptionMapper;
import ee.valiit.back_bank_26.domain.atm.option.OptionRepository;
import ee.valiit.back_bank_26.domain.city.City;
import ee.valiit.back_bank_26.domain.city.CityDto;
import ee.valiit.back_bank_26.domain.city.CityMapper;
import ee.valiit.back_bank_26.domain.city.CityRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    private AtmOptionRepository atmOptionRepository;

    @Resource
    private CityMapper cityMapper;

    @Resource
    private OptionMapper optionMapper;

    @Resource
    private LocationMapper locationMapper;

    @Resource
    private AtmOptionMapper atmOptionMapper;



    @GetMapping("/city")
    @Operation(summary = "This method retrieves all cities.", description = "And perhaps something else as well?")
    public List<CityDto> getAllCities() {
        List<City> allEntities = cityRepository.findAll();
        List<CityDto> cityDtos = cityMapper.citiesToCityDtos(allEntities);
        return cityDtos;
    }

    @GetMapping("/option")
    @Operation(summary = "This method retrieves all possible functions of ATMs (cash in/out/etc)")
    public List<OptionDto> getAllAtmOptions() {
        List<Option> entities = optionRepository.findAll();
        List<OptionDto> optionDtos = optionMapper.toDtos(entities);
        return optionDtos;
    }

    @GetMapping("/info")
    @Operation(summary = "This method retrieves all atm locations")
    public List<LocationDto> getAllAtmLocations() {
        

        List<Location> locations = locationRepository.findAll();
        List<LocationDto> locationDtos = locationMapper.toDtos(locations);

        List<Option> options = optionRepository.findAll();

    for(LocationDto locationDto : locationDtos){
        // Järve Selver
        List<AtmOption> availableOptions = atmOptionRepository.findAtmOptionsBy(locationDto.getLocationId());
        List<AtmOptionDto> availableOptionsDtos = new ArrayList<>();

        for (Option option : options) {
            // Raha sisse
            for (AtmOption atmOption : availableOptions) {
                // AAA kolm korda, BBB kaks korda
                if (option.getName().equals(atmOption.getOption().getName())) {
                    AtmOptionDto atmOptionDto = new AtmOptionDto();
                    atmOptionDto.setOptionName(option.getName());
                    availableOptionsDtos.add(atmOptionDto);
                    break;
                }
            }
        }

        locationDto.setOptions(availableOptionsDtos);
    }
        return locationDtos;
    }

}
