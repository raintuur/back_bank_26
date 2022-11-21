package ee.valiit.back_bank_26.atm;

import ee.valiit.back_bank_26.domain.atm.location.LocationDto;
import ee.valiit.back_bank_26.domain.atm.option.OptionDto;
import ee.valiit.back_bank_26.domain.city.CityDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/atm")
public class AtmController {

    @Resource
    private AtmService atmService;

    @GetMapping("/info/by-city")
    @Operation(summary = "Leiab pangaautomaatide asukohad linna ID'de järgi")
    public List<LocationDto> getAtmLocationsByCityId(@RequestParam Integer cityId) {
        return atmService.getAtmLocationsByCityId(cityId);
    }

    @GetMapping("/city")
    @Operation(summary = "Selle teenusega saad kätte kõik linnad", description = "Mingi pike jutt")
    public List<CityDto> getAllCities() {
        return atmService.getAllCities();
    }

    @GetMapping("/option")
    @Operation(summary = "Leiab kõikide automaatide võimalikud valikud (sularaha välja, sularaha sisse, jne")
    public List<OptionDto> getAllAtmOptions() {
        return atmService.getAllAtmOptions();
    }

    @GetMapping("/info")
    @Operation(summary = "Leiab kõikide pangaautomaatide asukohad")
    public List<LocationDto> getAllAtmLocations() {
        return atmService.getAllAtmLocations();
    }

    @PostMapping("")
    public void addAtm(@RequestBody AtmRequest request) {
        atmService.addAtm(request);
    }


}
