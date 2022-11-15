package ee.valiit.back_bank_26;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AtmController {

    @GetMapping("/atm/city")
    public List<City> getCitiesInfo() {
        List<City> cityInfos = BackBank26Application.findAllCities();
        return cityInfos;
    }

    @GetMapping("/atm/service")
    public List<AtmServiceDto> getAtmServiceInfo() {

        List<AtmService> serviceList = BackBank26Application.findAllAtmServices();
        List<AtmServiceDto> resultList = new ArrayList<>();

        for (AtmService service: serviceList) {
            AtmServiceDto atmServiceDto = new AtmServiceDto();
            atmServiceDto.setServiceId(service.getId());
            atmServiceDto.setServiceName(service.getName());
            resultList.add(atmServiceDto);
        }

        return resultList;

    }
}

