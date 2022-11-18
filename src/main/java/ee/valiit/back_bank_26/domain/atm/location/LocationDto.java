package ee.valiit.back_bank_26.domain.atm.location;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Location} entity
 */
@Data
public class LocationDto implements Serializable {
    private final String locationName;
    private final String cityName;
}