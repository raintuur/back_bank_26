package ee.valiit.back_bank_26;

public class City {
    private String cityName;
    private Integer cityNameId;

    public City() {}

    public City(String cityName, Integer cityNameId) {
        this.cityName = cityName;
        this.cityNameId = cityNameId;
    }

    public Integer getCityNameId() {
        return cityNameId;
    }

    public String getCityName() {
        return cityName;
    }



    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCityNameId(Integer cityNameId) {
        this.cityNameId = cityNameId;
    }
}