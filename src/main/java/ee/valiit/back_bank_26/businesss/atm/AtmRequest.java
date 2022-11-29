package ee.valiit.back_bank_26.businesss.atm;

import ee.valiit.back_bank_26.domain.atm.option.OptionDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class AtmRequest {

    @NotNull (message = "Oled loll")
    private Integer locationId;

    @Size(min = 1, max = 20, message = "Oled jalle loll")
    private String serialNumber;
    private String status;
    private List<OptionDto> options;
}

