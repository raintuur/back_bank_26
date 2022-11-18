package ee.valiit.back_bank_26.domain.city;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CityMapper {
    City cityDtoToCity(CityDto cityDto);

    @Mapping(source = "id", target = "cityNameId")
    @Mapping(source = "name", target = "cityName")
    CityDto cityToCityDto(City city);

    List<CityDto> citiesToCityDtos(List<City> cities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    City updateCityFromCityDto(CityDto cityDto, @MappingTarget City city);
}
