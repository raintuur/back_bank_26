package ee.valiit.back_bank_26.atm;

import ee.valiit.back_bank_26.BackBank26Application;
import ee.valiit.back_bank_26.CityInfo;
import ee.valiit.back_bank_26.city.City;
import ee.valiit.back_bank_26.city.CityMapperImpl;
import ee.valiit.back_bank_26.city.CityRepositoryImpl;
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

        CityMapperImpl cityMapper = new CityMapperImpl();
        cityMapper.citiesToCityInfos(cities);

        List<CityInfo> cityInfos = cityMapper.citiesToCityInfos(cities);

        return cityInfos;
    }


    @GetMapping("/atm/service")
    public List<AtmServiceInfo> getAtmServices() {

        AtmServiceRepositoryImpl atmServiceRepository = new AtmServiceRepositoryImpl();
        List<AtmService> atmServices= atmServiceRepository.getAllAtmServices();



        List<AtmServiceInfo> resultList = new ArrayList<>();

        for (AtmService entity : atmServiceEntities) {
            AtmServiceInfo dto = new AtmServiceInfo();
            dto.setServiceId(entity.getId());
            dto.setServiceName(entity.getName());

            dto.setIsSelected(entity.getName().equals("Maksed"));

            resultList.add(dto);
        }

        return resultList;
    }

    @GetMapping("/atm/info")
    public void getAllAtmLocations() {

    }


}
