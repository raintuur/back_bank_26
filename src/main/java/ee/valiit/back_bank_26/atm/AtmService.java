package ee.valiit.back_bank_26.atm;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//entity, service on halb nimi, service on kiht kus on sees äriloogika
public class AtmService {
    private Integer id;
    private String name;

    public AtmService(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
