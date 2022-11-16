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

        // TODO: 5) Tee kõik mäppimine kasutades mapperit

        CityMapperImpl cityMapper = new CityMapperImpl();
        List<CityInfo>cityInfos = cityMapper.citiesToCityInfos(cities);


        return cityInfos;
    }


    @GetMapping("/atm/service")
    public List<AtmServiceInfo> getAtmServices() {
        List<AtmService> atmServiceEntities = BackBank26Application.findAllAtmServices();

        List<AtmServiceInfo> resultList = new ArrayList<>();

        for (AtmService entity : atmServiceEntities) {
            AtmServiceInfo dto = new AtmServiceInfo();
            dto.setServiceId(entity.getId());
            dto.setServiceName(entity.getName());

            if (entity.getName().equals("Maksed")) {
                dto.setIsSelected(true);
            } else {
                dto.setIsSelected(false);

            }

            resultList.add(dto);
        }

        AtmServiceInfo atmInfo = new AtmServiceInfo();

        return resultList;
    }

    @GetMapping("/atm/info")
    public void getAllAtmLocations() {

    }

}

