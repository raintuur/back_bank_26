package ee.valiit.back_bank_26.atm;

import ee.valiit.back_bank_26.domain.atm.option.OptionDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
public class AtmRequest implements Serializable {
    private Integer locationId;
    private String serialNumber;
    private String status;
    private List<OptionDto> options;

}
