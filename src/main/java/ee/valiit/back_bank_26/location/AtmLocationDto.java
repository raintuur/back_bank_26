package ee.valiit.back_bank_26.location;

import ee.valiit.back_bank_26.atm.ServiceNameDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AtmLocationDto {

    private String cityName;
    private String atmLocationInfo;
    private List<ServiceNameDto> atmServices;

}
