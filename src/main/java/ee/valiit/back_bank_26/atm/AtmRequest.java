package ee.valiit.back_bank_26.atm;

import ee.valiit.back_bank_26.domain.atm.option.OptionDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class AtmRequest {
    @NotNull(message = "Oled loll. Null ei sobi siia")
    private Integer locationId;

    @Size(min = 1, max = 20, message = "seerianumber peab olema pikem kui 1 ja lühem kui 20 tähemärki")
    private String serialNumber;
    private String status;
    private List<OptionDto> options;
}

