package ee.valiit.back_bank_26.atm;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class AtmLocationInfo {
    @Size(max = 255)
    @NotNull
    private final String cityName;
    @Size(max = 255)
    @NotNull
    private final String locationName;
    private final List<Optsion> optsions;
}
