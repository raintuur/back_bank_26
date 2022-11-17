package ee.valiit.back_bank_26.city;

import ee.valiit.back_bank_26.CityInfo;

import java.util.List;

public interface CityMapper {


    CityInfo cityToCityInfo(City city);

    List<CityInfo> citiesToCityInfos(List<City> cities);

}
