package ee.valiit.back_bank_26.business.atm;

import ee.valiit.back_bank_26.business.atm.dto.AtmOptionDto;
import ee.valiit.back_bank_26.business.atm.dto.AtmRequest;
import ee.valiit.back_bank_26.domain.atm.Atm;
import ee.valiit.back_bank_26.domain.atm.AtmMapper;
import ee.valiit.back_bank_26.domain.atm.AtmService;
import ee.valiit.back_bank_26.domain.atm.atmoption.AtmOption;
import ee.valiit.back_bank_26.domain.atm.atmoption.AtmOptionService;
import ee.valiit.back_bank_26.domain.atm.location.Location;
import ee.valiit.back_bank_26.domain.atm.location.LocationDto;
import ee.valiit.back_bank_26.domain.atm.location.LocationMapper;
import ee.valiit.back_bank_26.domain.atm.location.LocationService;
import ee.valiit.back_bank_26.domain.atm.option.Option;
import ee.valiit.back_bank_26.domain.atm.option.OptionDto;
import ee.valiit.back_bank_26.domain.atm.option.OptionMapper;
import ee.valiit.back_bank_26.domain.atm.option.OptionService;
import ee.valiit.back_bank_26.domain.city.City;
import ee.valiit.back_bank_26.domain.city.CityDto;
import ee.valiit.back_bank_26.domain.city.CityMapper;
import ee.valiit.back_bank_26.domain.city.CityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BankAtmService {

    @Resource
    private AtmService atmService;

    @Resource
    private AtmOptionService atmOptionService;

    @Resource
    private CityService cityService;

    @Resource
    private LocationService locationService;

    @Resource
    private OptionService optionService;

    @Resource
    private AtmMapper atmMapper;

    @Resource
    private CityMapper cityMapper;

    @Resource
    private LocationMapper locationMapper;

    @Resource
    private OptionMapper optionMapper;


    public List<CityDto> getAllCities() {
        List<City> allEntities = cityService.findAll();
        List<CityDto> allDtos = cityMapper.citiesToCityDtos(allEntities);
        return allDtos;
    }

    public List<LocationDto> getAllAtmLocations() {
        List<Location> locations = locationService.findAll();
        List<LocationDto> locationDtos = createLocationDtos(locations);
        return locationDtos;
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
        List<Option> options = atmOptionService.findOptionsBy(dto.getLocationId());
        List<AtmOptionDto> atmOptionDtos = optionMapper.toAtmOptionDtos(options);
        dto.setOptions(atmOptionDtos);
    }




    public List<LocationDto> getAtmLocationsByCityId(Integer cityId) {
        List<Location> locations = locationService.findLocationsBy(cityId);
        List<LocationDto> locationDtos = createLocationDtos(locations);
        return locationDtos;
    }

    public List<OptionDto> getAllAtmOptions() {
        List<Option> entities = optionService.findAll();
        List<OptionDto> optionDtos = optionMapper.toDtos(entities);
        return optionDtos;

    }

    public void addAtm(AtmRequest request) {
        Atm atm = atmMapper.toEntity(request);
        Location location = locationService.findById(request.getLocationId());
        atm.setLocation(location);
        atmService.addAtm(atm);

        List<OptionDto> options = request.getOptions();
        for (OptionDto option : options) {
            if (option.getIsSelected()) {
                Integer optionId = option.getOptionId();
                Option optionEntity = optionService.findById(optionId);
                AtmOption atmOption = new AtmOption();
                atmOption.setAtm(atm);
                atmOption.setOption(optionEntity);
                atmOptionService.addAtmOption(atmOption);
            }
        }
        System.out.println();
    }

}
