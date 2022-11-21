package ee.valiit.back_bank_26.atm;

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
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AtmService {

    @Resource
    private CityRepository cityRepository;

    @Resource
    private OptionRepository optionRepository;

    @Resource
    private AtmOptionRepository atmOptionRepository;

    @Resource
    private LocationRepository locationRepository;

    @Resource
    private CityMapper cityMapper;

    @Resource
    private OptionMapper optionMapper;

    @Resource
    private LocationMapper locationMapper;

    public List<LocationDto> getAllAtmLocations() {
        List<Location> locations = locationRepository.findAll();
        List<LocationDto> locationDtos = locationMapper.toDtos(locations);
        addAtmOptions(locationDtos);
        return locationDtos;
    }

    public List<OptionDto> getAllAtmOptions() {
        List<Option> entities = optionRepository.findAll();
        List<OptionDto> optionDtos = optionMapper.toDtos(entities);
        return optionDtos;

    }

    public List<CityDto> getAllCities() {
        List<City> allEntities = cityRepository.findAll();
        List<CityDto> allDtos = cityMapper.citiesToCityDtos(allEntities);
        return allDtos;
    }

    private void addAtmOptions(List<LocationDto> locationDtos) {
        for (LocationDto dto : locationDtos) {
            addAtmOptionsToLocationDto(dto);
        }
    }

    private void addAtmOptionsToLocationDto(LocationDto dto) {
        List<Option> options = atmOptionRepository.findAtmOptionNamesBy(dto.getLocationId());
        List<AtmOptionDto> atmOptionDtos = optionMapper.toAtmOptionDtos(options);
        dto.setOptions(atmOptionDtos);

// Selline versioon kus
//          atmOptionRepository.findAtmOptionNamesBy(dto.getLocationId())
//          tagastas option tabeli veeru name väärtused List<String> ina

//        List<AtmOptionDto> atmOptionDtos = new ArrayList<>();
//        List<String> optionNames = atmOptionRepository.findAtmOptionNamesBy(dto.getLocationId());
//        for (String optionName : optionNames) {
//            AtmOptionDto atmOptionDto = new AtmOptionDto(optionName);
//            atmOptionDtos.add(atmOptionDto);
//        }
//        dto.setOptions(atmOptionDtos);
    }


}
