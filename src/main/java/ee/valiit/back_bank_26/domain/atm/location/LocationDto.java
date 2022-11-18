package ee.valiit.back_bank_26.domain.atm.location;

import ee.valiit.back_bank_26.atm.AtmOptionDto;
import ee.valiit.back_bank_26.domain.atm.option.OptionDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Location} entity
 */
@Data
public class LocationDto implements Serializable {
    private final Integer locationId;
    @Size(max = 255)
    @NotNull
    private final String cityName;
    @Size(max = 255)
    @NotNull
    private final String locationName;
    private final List<AtmOptionDto> options;
}