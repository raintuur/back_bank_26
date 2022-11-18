package ee.valiit.back_bank_26.domain.atm.location;

import ee.valiit.back_bank_26.atm.AtmOptionDto;
import ee.valiit.back_bank_26.domain.atm.option.OptionDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Location} entity
 */
@Data
public class LocationDto implements Serializable {
    private Integer locationId;
    private final String cityName;
    private final String locationName;
    private List<AtmOptionDto> options;
}