package ee.valiit.back_bank_26.atm;

import ee.valiit.back_bank_26.domain.atm.option.OptionDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AtmRequest {
    private Integer locationId;
    private String serialNumber;
    private String status;
    private List<OptionDto> options;
}
