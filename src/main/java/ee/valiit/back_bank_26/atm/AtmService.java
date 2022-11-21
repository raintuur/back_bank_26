package ee.valiit.back_bank_26.atm;

import ee.valiit.back_bank_26.domain.atm.atm.Atm;
import ee.valiit.back_bank_26.domain.atm.atm.AtmMapper;
import ee.valiit.back_bank_26.domain.atm.atm.AtmRepository;
import ee.valiit.back_bank_26.domain.atm.atm_option.AtmOption;
import ee.valiit.back_bank_26.domain.atm.atm_option.AtmOptionMapper;
import ee.valiit.back_bank_26.domain.atm.atm_option.AtmOptionRepository;
import ee.valiit.back_bank_26.domain.atm.location.Location;
import ee.valiit.back_bank_26.domain.atm.location.LocationMapper;
import ee.valiit.back_bank_26.domain.atm.location.LocationRepository;
import ee.valiit.back_bank_26.domain.atm.option.Option;
import ee.valiit.back_bank_26.domain.atm.option.OptionDto;
import ee.valiit.back_bank_26.domain.atm.option.OptionMapper;
import ee.valiit.back_bank_26.domain.atm.option.OptionRepository;
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
    private LocationRepository locationRepository;
    @Resource
    private AtmOptionRepository atmOptionRepository;
    @Resource
    private AtmRepository atmRepository;
    @Resource
    private CityMapper cityMapper;
    @Resource
    private OptionMapper optionMapper;
    @Resource
    private LocationMapper locationMapper;
    @Resource
    private AtmMapper atmMapper;
    @Resource
    private AtmOptionMapper atmOptionMapper;

    public List<AtmLocationInfo> getAtmLocationByCity(Integer cityId) {
        List<Location> locations = locationRepository.findLocationsBy(cityId);
        return createAtmLocationInfos(locations);
    }

    public List<CityDto> getAllCities() {
        return cityMapper.citiesTocityDtos(cityRepository.findAll());
    }

    public List<OptionDto> getAllOptions() {
        return optionMapper.toDtos(optionRepository.findAll());

    }

    public List<AtmLocationInfo> getAllAtmLocations() {

        List<Location> locations = locationRepository.findAll();
        return createAtmLocationInfos(locations);
    }

    public void postNewAtm(AtmRequest atmRequest) {
        Atm atm = atmMapper.atmRequestToEntity(atmRequest);
        Location location = locationRepository.findById(atmRequest.getLocationId()).get();
        atm.setLocation(location);
        atmRepository.save(atm);

        for (OptionDto atmOption : atmRequest.getOptions()) {
            if (atmOption.isSelected()) {
                Option optionEntity = optionRepository.findById(atmOption.getOptionId()).get();
                AtmOption atmOptionEntity = new AtmOption();
                atmOptionEntity.setAtm(atm);
                atmOptionEntity.setOption(optionEntity);
                atmOptionRepository.save(atmOptionEntity);
            }
        }
    }

    private List<AtmLocationInfo> createAtmLocationInfos(List<Location> locations) {
        List<AtmLocationInfo> atmLocationInfos = locationMapper.toDtos(locations);
        addAtmLocations(atmLocationInfos);
        return atmLocationInfos;
    }

    private void addAtmLocations(List<AtmLocationInfo> atmLocationInfos) {
        for (AtmLocationInfo atmLocationInfo : atmLocationInfos) {
            List<Option> availableOptions = atmOptionRepository.findOptionsBy(atmLocationInfo.getLocationId());
            List<AtmOptionDto> atmOptionDtos = optionMapper.toAtmOptionDtos(availableOptions);
            atmLocationInfo.setAtmOptions(atmOptionDtos);
        }
    }
}
