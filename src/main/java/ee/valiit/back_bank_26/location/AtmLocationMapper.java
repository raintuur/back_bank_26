package ee.valiit.back_bank_26.location;

import java.util.List;

public interface AtmLocationMapper {

    AtmLocationDto locationToLocationDto(Location location);

    List<AtmLocationDto> locationsToLocationsDto();

}
