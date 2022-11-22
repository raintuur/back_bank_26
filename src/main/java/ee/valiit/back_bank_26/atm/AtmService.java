package ee.valiit.back_bank_26.atm;

import ee.valiit.back_bank_26.domain.atm.atm.Atm;
import ee.valiit.back_bank_26.domain.atm.atm.AtmMapper;
import ee.valiit.back_bank_26.domain.atm.atm.AtmRepository;
import ee.valiit.back_bank_26.domain.atm.atmoption.AtmOption;
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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

//@Slf4j
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

    @Resource
    private AtmMapper atmMapper;

    @Resource
    private AtmRepository atmRepository;

    public List<LocationDto> getAllAtmLocations() {
        List<Location> locations = locationRepository.findAll();
        List<LocationDto> locationDtos = createLocationDtos(locations);
        return locationDtos;
    }

    public List<LocationDto> getAtmLocationsByCityId(Integer cityId) {
        List<Location> locations = locationRepository.findLocationsBy(cityId);
        List<LocationDto> locationDtos = createLocationDtos(locations);
        return locationDtos;
    }

    public List<OptionDto> getAllAtmOptions() {
        List<Option> entities = optionRepository.findAll();
        List<OptionDto> dtos = optionMapper.toDtos(entities);
        return dtos;
    }

    public List<CityDto> getAllCities() {
        List<City> allEntities = cityRepository.findAll();
        List<CityDto> allDtos = cityMapper.citiesToCityDtos(allEntities);
        return allDtos;
    }

    private List<LocationDto> createLocationDtos(List<Location> locations) {
        List<LocationDto> locationDtos = locationMapper.toDtos(locations);
        addAtmOptions(locationDtos);
        return locationDtos;
    }

    private void addAtmOptions(List<LocationDto> locationDtos) {
        for (LocationDto dto : locationDtos) {
            addAtmOptionsToLocationDto(dto);
        }
    }

    private void addAtmOptionsToLocationDto(LocationDto dto) {
        List<Option> options = atmOptionRepository.findOptionsBy(dto.getLocationId());
        List<AtmOptionDto> atmOptionDtos = optionMapper.toAtmOptionDtos(options);
        dto.setOptions(atmOptionDtos);

        //Selline versioon, kus
        // atmOptionRepository.findAtmOptionNamesBy(dto.getLocationId())
        // tagastas option tabeli veeru name väärtused List<String> ina

//        List<AtmOptionDto> atmOptionsDtos = new ArrayList<>();
//        List<String> optionNames = atmOptionRepository.findAtmOptionNamesBy(dto.getLocationId());
//
//        for (String optionName : optionNames) {
//            AtmOptionDto atmOptionDto = new AtmOptionDto(optionName);
//            atmOptionsDtos.add(atmOptionDto);
//        }
//
//        dto.setOptions(atmOptionsDtos);
    }

    public void addAtm(AtmRequest request) {
        Atm atm = atmMapper.toEntity(request);
//        log.info("Request id is: {}", request.getLocationId());
        Location location = locationRepository.findById(request.getLocationId()).get();
        atm.setLocation(location);
        atmRepository.save(atm);

        List<OptionDto> options = request.getOptions();
        for (OptionDto option : options) {
            if (option.getIsSelected()) {
                Integer optionId = option.getOptionId();
                Option optionEntity = optionRepository.findById(optionId).get();

                AtmOption atmOption = new AtmOption();
                atmOption.setAtm(atm);
                atmOption.setOption(optionEntity);
                atmOptionRepository.save(atmOption);
            }
        }
        System.out.println();
    }
}
