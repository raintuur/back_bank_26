package ee.valiit.back_bank_26.atm;

import ee.valiit.back_bank_26.domain.atm.location.LocationDto;
import ee.valiit.back_bank_26.domain.atm.option.OptionDto;
import ee.valiit.back_bank_26.domain.city.CityDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/atm")
public class AtmController {

    @Resource
    private AtmService atmService;


    @GetMapping("/city")
    @Operation(summary = "This method retrieves all cities.", description = "And perhaps something else as well?")
    public List<CityDto> getAllCities() {
        List<CityDto> result = atmService.getAllCities();
        return result;
    }

    @GetMapping("/option")
    @Operation(summary = "This method retrieves all possible functions of ATMs (cash in/out/etc)")
    public List<OptionDto> getAllAtmOptions() {
        List<OptionDto> result = atmService.getAllAtmOptions();
        return result;
    }

    @GetMapping("/info")
    @Operation(summary = "This method retrieves all atm locations")
    public List<LocationDto> getAllAtmLocations() {
        List<LocationDto> result = atmService.getAllAtmLocations();
        return result;
    }
}
