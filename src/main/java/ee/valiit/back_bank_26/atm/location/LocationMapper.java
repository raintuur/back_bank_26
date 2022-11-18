package ee.valiit.back_bank_26.atm.location;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LocationMapper {


    @Mapping(source = "name", target = "locationName")
    @Mapping(source = "city.name", target = "cityName")
    LocationDto toDto(Location location);
}
