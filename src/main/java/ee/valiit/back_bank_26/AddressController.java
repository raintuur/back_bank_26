package ee.valiit.back_bank_26;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AddressController {


    @GetMapping(value = "/atm/city")
    public List<City> getCitiesInfo() {
        List<City> cities = BackBank26Application.findAllCities();

        return cities;

        // todo: tagasta list<> objektidest
        // objekti sees peavad olema väljad 'cityName' ja 'cityNameId'
    }

}

