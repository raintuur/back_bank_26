package ee.valiit.back_bank_26.city;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City {
    private Integer id;
    private String name;

    public City(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
