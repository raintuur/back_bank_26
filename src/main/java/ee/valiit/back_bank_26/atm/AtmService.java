package ee.valiit.back_bank_26.atm;

import lombok.*;

@Getter
@Setter
public class AtmService {
    private Integer id;
    private String name;

    public AtmService(int id, String name) {
        this.id = id;
        this.name = name;

    }
}
