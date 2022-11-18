package ee.valiit.back_bank_26.city;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CityMapper {

    CityDto cityToCityDto(City city);

    List<CityDto> citiesToCityDtos(List<City> cities);

}
