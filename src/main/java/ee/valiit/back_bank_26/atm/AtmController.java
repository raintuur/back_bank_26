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
        return cityRepository.findAllCities();
    }

    @GetMapping("/atm/service")
    public List<AtmServiceDto> getAtmServiceInfo() {

        List<AtmService> serviceList = BackBank26Application.findAllAtmServices();
        List<AtmServiceDto> resultList = new ArrayList<>();

        for (AtmService service: serviceList) {
            AtmServiceDto atmServiceDto = new AtmServiceDto();
            atmServiceDto.setServiceId(service.getId());
            atmServiceDto.setServiceName(service.getName());
            atmServiceDto.setIsSelected(false);
            resultList.add(atmServiceDto);
        }

        return resultList;

    }

    @GetMapping("/atm/info")
    public void getAtmLocationByName() {

    }


}

