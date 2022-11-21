package ee.valiit.back_bank_26.atm;

import ee.valiit.back_bank_26.domain.atm.atmoption.AtmOptionRepository;
import ee.valiit.back_bank_26.domain.atm.location.Location;
import ee.valiit.back_bank_26.domain.atm.location.LocationDto;
import ee.valiit.back_bank_26.domain.atm.location.LocationMapper;
import ee.valiit.back_bank_26.domain.atm.location.LocationRepository;
import ee.valiit.back_bank_26.domain.atm.option.OptionMapper;
import ee.valiit.back_bank_26.domain.atm.option.OptionRepository;
import ee.valiit.back_bank_26.domain.city.CityMapper;
import ee.valiit.back_bank_26.domain.city.CityRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AtmSerivce {

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

    public List<LocationDto> getAllAtmLocations(){
        List<Location> locations = locationRepository.findAll();
        List<LocationDto> locationDtos = locationMapper.toDtos(locations);
        addAtmOptions(locationDtos);
        return locationDtos;
    }

}
