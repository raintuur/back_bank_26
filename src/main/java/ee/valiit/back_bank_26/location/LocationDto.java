package ee.valiit.back_bank_26.location;

import ee.valiit.back_bank_26.atm.ServiceDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LocationDto {
    private String cityName;
    private String atmLocationInfo;
    private List<ServiceDto> atmServices;
}
