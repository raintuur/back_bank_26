package ee.valiit.back_bank_26.city;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CityMapper {
    @Mapping(source = "cityNameId", target = "id")
    @Mapping(source = "cityName", target = "name")
    City cityDtoToCity(CityDto cityDto);

    @InheritInverseConfiguration(name = "cityDtoToCity")
    CityDto cityToCityDto(City city);

    @InheritConfiguration(name = "cityDtoToCity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    City updateCityFromCityDto(CityDto cityDto, @MappingTarget City city);

    List<CityDto> citiesTocityDtos (List<City> cities);

}
