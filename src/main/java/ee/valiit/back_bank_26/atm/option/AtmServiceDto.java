package ee.valiit.back_bank_26.atm.option;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link AtmService} entity
 */





@Data
public class AtmServiceDto implements Serializable {
    private final Integer serviceId;
    @Size(max = 255)
    @NotNull
    private final String serviceName;
}