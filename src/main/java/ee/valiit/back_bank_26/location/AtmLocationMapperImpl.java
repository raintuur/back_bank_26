package ee.valiit.back_bank_26.location;

import java.util.ArrayList;
import java.util.List;

public class AtmLocationMapperImpl implements AtmLocationMapper {

    private static List<AtmLocationDto> locationsDto = new ArrayList<>();

    @Override
    public AtmLocationDto locationToLocationDto(Location location) {
        AtmLocationDto locationDto = new AtmLocationDto();
        locationDto.setAtmLocationInfo(location.getName());
        locationDto.setCityName(location.getCity().getName());

        return null;
    }

    @Override
    public List<AtmLocationDto> locationsToLocationsDto() {
        return locationsDto;
    }
}
