package ee.valiit.back_bank_26;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtmController {

    @GetMapping("/atm/city")
    public String getCitiesInfo() {

        return null;
    }

    @GetMapping("/atm/service")
    public String getAtmServiceInfo() {
        return null;
    }

    @GetMapping("/atm/info")
    public String getAtmLocationByName() {
        return null;
    }
}

