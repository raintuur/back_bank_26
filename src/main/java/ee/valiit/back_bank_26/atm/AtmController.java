package ee.valiit.back_bank_26.atm;

import ee.valiit.back_bank_26.domain.atm.atm_option.AtmOptionMapper;
import ee.valiit.back_bank_26.domain.atm.atm_option.AtmOptionRepository;
import ee.valiit.back_bank_26.domain.atm.location.Location;
import ee.valiit.back_bank_26.domain.atm.location.LocationMapper;
import ee.valiit.back_bank_26.domain.atm.location.LocationRepository;
import ee.valiit.back_bank_26.domain.atm.option.OptionDto;
import ee.valiit.back_bank_26.domain.atm.option.OptionMapper;
import ee.valiit.back_bank_26.domain.atm.option.OptionRepository;
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


    @GetMapping("/city")
    @Operation(summary = "This returns all city names and id-s for dropdownbox")
    public List<CityDto> getAllCities() {
        return cityMapper.citiesTocityDtos(cityRepository.findAll());
    }

    @GetMapping("/option")
    @Operation(summary = "This returns all option names for radio buttons", description = "Something Something")
    public List<OptionDto> getAllOptions() {
        return optionMapper.toDtos(optionRepository.findAll());
    }

    @GetMapping("/info")
    @Operation(summary = "this returns atm and atm location info for atm info table generation",
            description = "Returns city name, atm location, available service options")
    public List<AtmLocationInfo> getAtmLocationByName() {

        List<Location> locations = locationRepository.findAll();
        List<AtmLocationInfo> atmLocationInfos = locationMapper.toDtos(locations);

        addAtmLocations(atmLocationInfos);
        return atmLocationInfos;

    }

    private void addAtmLocations(List<AtmLocationInfo> atmLocationInfos) {
        for (AtmLocationInfo atmLocationInfoDto : atmLocationInfos) {

            addAtmOptionsToLocationDto(atmLocationInfoDto);
        }
    }

    private void addAtmOptionsToLocationDto(AtmLocationInfo atmLocationInfo) {
        List<String> availableOptions = atmOptionRepository.findAtmOptionNamesBy(atmLocationInfo.getLocationId());
        List<AtmOptionDto> atmOptionDtos = new ArrayList<>();

        for (String availableOption : availableOptions) {
            AtmOptionDto atmOptionDto = new AtmOptionDto(availableOption);
            atmOptionDtos.add(atmOptionDto);
        }
        atmLocationInfo.setAtmOptions(atmOptionDtos);
    }
}

