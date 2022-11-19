package ee.valiit.back_bank_26.atm;

import ee.valiit.back_bank_26.domain.atm.atm_option.AtmOption;
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
    private AtmOptionMapper atmOptionMapper;
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

        // Esimene loop vaatab ükshaaval eel pool loodud AtmLocationInfos Listi sisse ja teeme iga objektiga eraldi tööd.
        for (AtmLocationInfo atmLocationInfo : atmLocationInfos) {

            //Teeme uue listi, kus hakkame hoidma ühe ATM asukoha võimalike Optsioneid (Rahasisse, -välja või maksed)
            // ja kohe anname talle ka väärtused loodud query-ga. Siia listi tulevad ainult väärtused juhul,
            // kui antud asukoha ATM on optsioneid. Väärtused on Entity'd.
            List<AtmOption> availableOptions = atmOptionRepository.findAtmOptionsBy(atmLocationInfo.getLocationId());

            //Looma sama sama asja kohta Dto listi, et ümber tõsta entitiest Dto-ks.
            List<AtmOptionDto> availableOptionsDtos = new ArrayList<>();

            // Järgmine for loop, mille sees toimub ümber tõstmine ja üksikute Dto-de listi lisamine.
            // See võiks olla vast mõnes Mapperi Intefacesis.
            for (AtmOption availableOption : availableOptions) {
                AtmOptionDto atmOptionDto = new AtmOptionDto();
                atmOptionDto.setOptionName(availableOption.getOption().getName());
                availableOptionsDtos.add(atmOptionDto);
            }
            //Nüüd lisame real 75 loodud avilableOptionsDto List lõplikusse Dto-sse, mida saadame front end poole.
            atmLocationInfo.setAtmOptions(availableOptionsDtos);
        }
        return atmLocationInfos;


//            for (Option option : options) {
//
//                for (AtmOption atmOption : availableOptions) {
//                    if(option.getName().equals(atmOption.getOption().getName())) {
//                        AtmOptionDto atmOptionDto = new AtmOptionDto();
//                        atmOptionDto.setOptionName(option.getName());
//                        availableOptionsDtos.add(atmOptionDto);
//                        break;
//                    }
//                }
//            }
//            atmLocationInfo.setOptions(availableOptionsDtos);
//        }

    }
}

