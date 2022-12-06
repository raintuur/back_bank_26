package ee.valiit.back_bank_26.business.atm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtmOptionDto implements Serializable {
    private String optionName;
}
