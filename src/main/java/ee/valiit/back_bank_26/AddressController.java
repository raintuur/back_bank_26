package ee.valiit.back_bank_26;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @GetMapping("/atm/city")
    public void getCitiesInfo() {

    }

}
