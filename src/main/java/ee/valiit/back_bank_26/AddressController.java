package ee.valiit.back_bank_26;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class AddressController {

    @GetMapping("/atm/city")
    public List<City> getCitiesInfo() {
        List<City> cities = BackBank26Application.findAllCities();
        return cities;

        //todo: tagasta list <> objektidest
        //objekti sees peavad olema väljad: cityname ja city name id
    }


}