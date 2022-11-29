package ee.valiit.back_bank_26.business.atm;

import ee.valiit.back_bank_26.domain.atm.location.LocationDto;
import ee.valiit.back_bank_26.domain.atm.option.OptionDto;
import ee.valiit.back_bank_26.domain.city.CityDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/atm")
public class AtmController {

    @Resource
    private AtmService atmService;

    @GetMapping("/info/by-city")
    @Operation(summary = "Leiab pangaautomaatide asukohad linna ID'de järgi")
    public List<LocationDto> getAtmLocationsByCityId(@RequestParam Integer cityId) {
        List<LocationDto> result = atmService.getAtmLocationsByCityId(cityId);
        return result;
    }

    @GetMapping("/city")
    @Operation(summary = "Selle teenusega saad kätte kõik linnad", description = "Mingi pikem jutt rohkem mula")
    public List<CityDto> getAllCities() {
        List<CityDto> result = atmService.getAllCities();
        return result;
    }

    @GetMapping("/option")
    @Operation(summary = "Leiab kõik automaatide võimalikud valikud (sularaha välja, sulraha sisse, jne)")
    public List<OptionDto> getAllAtmOptions() {
        List<OptionDto> result = atmService.getAllAtmOptions();
        return result;
    }

    @GetMapping("/info")
    @Operation(summary = "Leiab kõikide pangaautomaatide asukohad")
    public List<LocationDto> getAllAtmLocations() {
        List<LocationDto> result = atmService.getAllAtmLocations();
        return result;
    }

    @PostMapping()
    @Operation(summary = "Pangaautomaadi lisamine asukohta")
    public void addAtm(@RequestBody @Valid AtmRequest request) {
        atmService.addAtm(request);
    }


}
