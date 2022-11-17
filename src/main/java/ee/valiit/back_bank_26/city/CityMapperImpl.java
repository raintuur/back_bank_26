package ee.valiit.back_bank_26.city;

import ee.valiit.back_bank_26.CityInfo;

import java.util.ArrayList;
import java.util.List;

public class CityMapperImpl implements CityMapper {

    @Override
    public CityInfo cityToCityInfo(City city) {
        CityInfo cityInfo = new CityInfo();
        cityInfo.setCityNameId(city.getId());
        cityInfo.setCityName(city.getName());
        return cityInfo;

    }

    @Override
    public List<CityInfo> citiesToCityInfos(List<City> cities) {
        List<CityInfo> result = new ArrayList<>();
        for (City city : cities) {
            CityInfo cityInfo = cityToCityInfo(city);
            result.add(cityInfo);
        }
        return result;
    }
}
