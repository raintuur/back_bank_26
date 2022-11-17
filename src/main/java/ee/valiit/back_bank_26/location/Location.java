package ee.valiit.back_bank_26.location;

import ee.valiit.back_bank_26.city.City;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    private Integer id;
    private City city;
    private String name;
    private Character status;
}
