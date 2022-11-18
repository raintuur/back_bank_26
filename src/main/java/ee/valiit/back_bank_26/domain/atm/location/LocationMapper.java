package ee.valiit.back_bank_26.domain.atm.location;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LocationMapper {

    @Mapping(source = "city.name", target = "cityName")
    @Mapping(source = "name", target = "locationName")
    @Mapping(source = "id", target = "locationId")
    LocationDto toDto(Location location);

    List<LocationDto> toDtos(List<Location> locations);


}
