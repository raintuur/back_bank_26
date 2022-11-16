package ee.valiit.back_bank_26.city;

import ee.valiit.back_bank_26.CityInfo;

import java.util.List;

public interface CityMapper {

    CityInfo cityToCityInfo(City city);

    //        TODO: 2) mäppida ümber List<City> (entity) -> List<CityInfo> (dto)

    List<CityInfo> citiesToCityInfos(List<City> cities );

}
