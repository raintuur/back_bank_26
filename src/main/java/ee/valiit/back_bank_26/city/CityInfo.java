package ee.valiit.back_bank_26.city;


public class CityInfo {

    private Integer cityNameId;
    private String cityName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getCityNameId() {
        return cityNameId;
    }

    public void setCityNameId(Integer cityNameId) {
        this.cityNameId = cityNameId;
    }
}