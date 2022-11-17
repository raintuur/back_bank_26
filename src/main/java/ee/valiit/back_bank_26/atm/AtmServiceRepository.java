package ee.valiit.back_bank_26.atm;

import java.util.ArrayList;
import java.util.List;

public interface AtmServiceRepository {


    // siia on vaja meetodit, mis tagastab kõik AtmService-d Listina (Entity)
    // mängime oma andmebaasi

    void createAtmServices();

    List<AtmService> getAllAtmServices();

}
