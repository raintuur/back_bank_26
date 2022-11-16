package ee.valiit.back_bank_26.city;


import ee.valiit.back_bank_26.CityInfo;

public class CityMapperImpl implements CityMapper {

    @Override
    public CityInfo cityToCityInfo(City city) {
        CityInfo cityInfo = new CityInfo();
        cityInfo.setCityNameId(city.getId());
        cityInfo.setCityName(city.getName());
        return cityInfo;
    }
}

