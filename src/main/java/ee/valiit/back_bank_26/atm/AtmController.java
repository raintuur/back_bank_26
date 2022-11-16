package ee.valiit.back_bank_26.atm;

import ee.valiit.back_bank_26.BackBank26Application;
import ee.valiit.back_bank_26.city.City;
import ee.valiit.back_bank_26.city.CityRepositoryImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AtmController {

    @GetMapping("/atm/city")
    public List<City> getCitiesInfo() {
        CityRepositoryImpl cityRepository = new CityRepositoryImpl();
        List<City> cities = cityRepository.findAllCities();
        //List<City> cities = BackBank26Application.findAllCities();
//        TODO: 1) mäppida ümber üksikobjekt city (entity) -> cityInfo (dto)
//        TODO: 2) mäppida ümber List<City> (entity) -> List<CityInfo> (dto)
//        TODO: 3) Loo mapper interface
//        TODO: 4) Loo mapperi implementatsioon
//        TODO: 5) tee kõik mappimine kasutades mapperit
        return cities;
    }

    @GetMapping("/atm/service")
    public List<AtmServiceInfo> getAtmServices() {
        List<AtmService> atmServiceEntities = BackBank26Application.findAllAtmServices();

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
    public void getAtmLocations() {

    }
}