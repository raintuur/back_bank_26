package ee.valiit.back_bank_26.city;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CityMapper {

    @Mapping(source = "id", target = "cityNameId")
    @Mapping(source = "name", target = "cityName")
    CityDto cityToCityDto(City city);

    List<CityDto> citiesToCityDtos(List<City> cities);

}
