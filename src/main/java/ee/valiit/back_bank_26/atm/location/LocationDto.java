package ee.valiit.back_bank_26.atm.location;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link Location} entity
 */
@Data
public class LocationDto implements Serializable {
    private final String cityName;
    private final String locationName;

}