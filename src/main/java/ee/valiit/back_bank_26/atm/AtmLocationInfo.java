package ee.valiit.back_bank_26.atm;

import ee.valiit.back_bank_26.domain.atm.option.Option;
import lombok.Data;

import java.util.List;

@Data
public class AtmLocationInfo {

    private String cityName;
    private String locationName;
    private List<AtmOptionDto> options;

}
