package ee.valiit.back_bank_26.atm;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class Optsion {
    @Size(max = 255)
    private final String optionName;
}
