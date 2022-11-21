package ee.valiit.back_bank_26.atm;

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
    private AtmService atmService;


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
        return getAtmOptions()


//        List<Option> entities = optionRepository.findAll();
//        List<OptionDto> optionDtos = optionMapper.toDtos(entities);
//        return optionDtos;
    }

    private List<OptionDto> getAtmOptions() {
        return atmService.getAllAtmOptions();
    }

    //
    @GetMapping("/info")
    @Operation(summary = "Leiab kõikide pangaautomaatide asukohad")
    public List<LocationDto> getAllAtmLocations() {
        return atmService.getAllAtmLocations();
    }

}
