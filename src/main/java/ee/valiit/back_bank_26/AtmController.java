package ee.valiit.back_bank_26;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AtmController {


    @GetMapping("/atm/city")
    public List<City> getCitiesInfo() {
        List<City> cities = BackBank26Application.findAllCities();
        return cities;
    }

    @GetMapping("/atm/service")
    public List<AtmService> getAtmServices() {


        return null;
    }

@GetMapping ("atm/service")
    public List<AtmService> getAtmServices () {

        return null;
}




}
