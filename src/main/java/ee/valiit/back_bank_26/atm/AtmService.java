package ee.valiit.back_bank_26.atm;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtmService {

    private Integer id;
    private String name;
    private boolean isSelected = false;

}
