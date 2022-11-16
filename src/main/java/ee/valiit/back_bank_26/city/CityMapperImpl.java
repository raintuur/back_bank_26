package ee.valiit.back_bank_26.city;

import java.util.ArrayList;
import java.util.List;

public class CityMapperImpl implements CityMapper {


    @Override
    public CityDto cityToCityDto(City city) {
        CityDto cityDto = new CityDto();
        cityDto.setCityId(city.getId());
        cityDto.setCityName(city.getName());
        return cityDto;
    }

    @Override
    public List<CityDto> citiesToCitiesDto(List<City> cities) {
        List<CityDto> result = new ArrayList<>();
        for (City city : cities) {
            CityDto cityDto = cityToCityDto(city);
            result.add(cityDto);
        }
        return result;
    }
}
