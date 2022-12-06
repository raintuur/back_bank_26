package ee.valiit.back_bank_26.business.atm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link ee.valiit.back_bank_26.domain.atm.location.Location} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationUpdate implements Serializable {
    @Size(max = 255)
    @NotNull
    private String locationName;
    @Size(max = 1)
    @NotNull
    private String locationStatus;
}