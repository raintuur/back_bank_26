package ee.valiit.back_bank_26.businesss.atm;


import lombok.Data;

import java.util.List;

@Data
public class AtmLocationInfo {
    private String cityName;
    private String locationName;
    private List<AtmOptionDto> options;
}
