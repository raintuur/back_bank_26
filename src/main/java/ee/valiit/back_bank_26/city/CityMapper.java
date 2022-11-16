package ee.valiit.back_bank_26.city;

import java.util.List;

public interface CityMapper {

    CityDto cityToCityDto(City city);

    List<CityDto> citiesToCitiesDto(List<City> cities);

}
