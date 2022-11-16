package ee.valiit.back_bank_26;



import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
