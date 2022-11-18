package ee.valiit.back_bank_26.atm.option;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link Option} entity
 */
@Data
public class OptionDto implements Serializable {
    private final Integer optionId;
    @Size(max = 255)
    @NotNull
    private final String optionName;
    private boolean isSelected = false;
}