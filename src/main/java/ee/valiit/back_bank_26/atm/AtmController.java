package ee.valiit.back_bank_26.atm;

import ee.valiit.back_bank_26.BackBank26Application;
import ee.valiit.back_bank_26.City;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AtmController {


    @GetMapping("/atm/city")
    public List<City> getCitiesInfo() {
        List<City> cities = BackBank26Application.findAllCities();
        return cities;
    }

    @GetMapping("/atm/service")
    public List<AtmServiceInfo> getAtmServices() {
        List<AtmService> atmServiceEntities = BackBank26Application.findAllAtmServices();

        List<AtmServiceInfo>resultList = new ArrayList<>();

        for (AtmService entity : atmServiceEntities) {
            AtmServiceInfo dto = new AtmServiceInfo();
            dto.setServiceId(entity.getId());
            dto.setServiceName(entity.getName());

            if (entity.getName().equals("Maksed")){
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

