package ee.valiit.back_bank_26.atm;

import ee.valiit.back_bank_26.BackBank26Application;
import ee.valiit.back_bank_26.CityInfo;
import ee.valiit.back_bank_26.city.City;
import ee.valiit.back_bank_26.city.CityMapper;
import ee.valiit.back_bank_26.city.CityMapperImpl;
import ee.valiit.back_bank_26.city.CityRepositoryImpl;
import ee.valiit.back_bank_26.location.LocationDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AtmController {

    @GetMapping("/atm/city")
    public List<CityInfo> getCitiesInfo() {
        CityRepositoryImpl cityRepository = new CityRepositoryImpl();
        List<City> cities = cityRepository.findAllCities();
        // todo: 1) mäppida ümber üksik objekt city(entity) -> cityInfo(dto)
        // todo: 2) mäppida ümber List<City> (entity) -> List<CityInfo>(dto)
        // todo: 3) Loo mapperi interface
        // todo: 4) Loo mapperi implementatsioon
        // todo: 5) Tee kõik mäppimine kasutades mapperit
        CityMapperImpl cityMapper = new CityMapperImpl();
        List<CityInfo> cityInfos = cityMapper.citiesToCityInfos(cities);
        return cityInfos;  //entityt ei tohi tegelikult tagasatada
    }

    @GetMapping("/atm/service")
    public List<AtmServiceInfo> getAtmServices() {
        AtmServiceRepositoryImpl atmServiceRepository = new AtmServiceRepositoryImpl();
        List<AtmService> atmServices = atmServiceRepository.getAllAtmServices();
        AtmMapperImpl atmMapper = new AtmMapperImpl();
        // todo: entititest teeme DTO-d
                // todo: vaja luua mäpper
                    // todo: üksik objekti mäpper
                    // todo: mitme objekti (listi) mäppimine teiseks Listiks
                    // todo: tagastame mäpitud listi (DTO list)
//        List<AtmServiceInfo> resultList = new ArrayList<>();
//        for (AtmService entity : atmServiceEntities) {
//            AtmServiceInfo dto = new AtmServiceInfo();
//            dto.setServiceId(entity.getId());
//            dto.setServiceName(entity.getName());
//            dto.setIsSelected(entity.getName().equals("Maksed"));
//            resultList.add(dto);
//        }
        return atmMapper.atmServicesToAtmServiceInfos(atmServices);
    }

    @GetMapping("/atm/info")
    public List<LocationDto> getAllAtmLocations() {
        List<LocationDto> result = new ArrayList<>();
        return result;
    }
}
