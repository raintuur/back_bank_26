package ee.valiit.back_bank_26.business.atm.dto;

import ee.valiit.back_bank_26.domain.atm.option.OptionDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class AtmRequest {

    @NotNull
    private Integer locationId;

    @Size(min = 1, max = 10)
    private String serialNumber;
    private String status;
    private List<OptionDto> options;
}

