package ee.valiit.back_bank_26;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class City {
    private Integer id;
    private String name;


    public City(Integer cityNameId, String cityName) {
        this.id = cityNameId;
        this.name = cityName;
    }


    }
