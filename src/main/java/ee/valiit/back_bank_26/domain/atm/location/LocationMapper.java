package ee.valiit.back_bank_26.domain.atm.location;

import ee.valiit.back_bank_26.bussiness.atm.AtmLocationInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LocationMapper {

    @Mapping(source = "city.name", target = "cityName")
    @Mapping(source = "name", target = "locationName")
    @Mapping(source = "id", target = "locationId")
    AtmLocationInfo toDto(Location location);

    List<AtmLocationInfo> toDtos(List<Location> locations);


}
