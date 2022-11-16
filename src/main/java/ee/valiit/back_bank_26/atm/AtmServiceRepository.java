package ee.valiit.back_bank_26.atm;

import java.util.ArrayList;
import java.util.List;

public interface AtmServiceRepository {

    void createAtmServices();
    //siia on vaja meetodid, mis tagastab kõik AtmService-d Listina (Entity)
    //mängime oma andmebaasi

    List<AtmService> getAllAtmServices();


}
