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
    public List<AtmService> getAtmServiceInfo() {
        List<AtmService> serviceInfo = BackBank26Application.findAllAtmServices();
        return serviceInfo;
    }
}

