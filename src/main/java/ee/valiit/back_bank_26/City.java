package ee.valiit.back_bank_26;

public class City {
    private Integer cityNameId;
    private String cityName;

    public City() {
    }

    public City(Integer cityNameId, String cityName) {
        this.cityNameId = cityNameId;
        this.cityName = cityName;
    }

    public Integer getCityNameId() {
        return cityNameId;
    }

    public void setCityNameId(Integer cityNameId) {
        this.cityNameId = cityNameId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
