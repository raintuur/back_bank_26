package ee.valiit.back_bank_26.bussiness.atm;

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
    @Operation(summary = "This returns table information filtered by city")
    public List<AtmLocationInfo> getAtmLocationByCityId(@RequestParam Integer cityId) {
        return atmService.getAtmLocationByCity(cityId);
    }

    @GetMapping("/city")
    @Operation(summary = "This returns all city names and id-s for dropdownbox")
    public List<CityDto> getAllCities() {
        return atmService.getAllCities();
    }

    @GetMapping("/option")
    @Operation(summary = "This returns all option names for radio buttons", description = "Something Something")
    public List<OptionDto> getAllOptions() {
        return atmService.getAllOptions();
    }

    @GetMapping("/info")
    @Operation(summary = "this returns atm and atm location info for atm info table generation",
            description = "Returns city name, atm location, available service options")
    public List<AtmLocationInfo> getAllAtmLocations() {
        return atmService.getAllAtmLocations();
    }

    @PostMapping("")
    @Operation(summary = "This serivce posts new atm to database")
    public void postNewAtm(@RequestBody AtmRequest atmRequest) {
        atmService.postNewAtm(atmRequest);
    }

}
