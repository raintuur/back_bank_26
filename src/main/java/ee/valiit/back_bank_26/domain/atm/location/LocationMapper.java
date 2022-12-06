package ee.valiit.back_bank_26.domain.atm.location;

import ee.valiit.back_bank_26.business.atm.LocationUpdate;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LocationMapper {


    @Mapping(source = "id", target = "locationId")
    @Mapping(source = "name", target = "locationName")
    @Mapping(source = "city.name", target = "cityName")
    LocationDto toDto(Location location);

    List<LocationDto> toDtos(List<Location> locations);


    @Mapping(source = "locationName", target = "name")
    @Mapping(source = "locationStatus", target = "status")
    void updateLocation(LocationUpdate locationUpdate, @MappingTarget Location location);

}
