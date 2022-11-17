package ee.valiit.back_bank_26.city;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link City} entity
 */
@Data
public class CityDto implements Serializable {
    private final Integer cityNameId;
    @Size(max = 255)
    @NotNull
    private final String cityName;
}