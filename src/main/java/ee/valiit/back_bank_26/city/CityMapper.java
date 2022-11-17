package ee.valiit.back_bank_26.city;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CityMapper {

    CityDto cityToCityDto(City city);

}
