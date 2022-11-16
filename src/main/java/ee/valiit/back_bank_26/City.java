package ee.valiit.back_bank_26;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City {

    private Integer id;
    private String name;

    public City(String name, Integer Id) {
        this.id = Id;
        this.name = name;

    }
}
