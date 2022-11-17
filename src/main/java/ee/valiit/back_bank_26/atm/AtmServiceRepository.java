package ee.valiit.back_bank_26.atm;

import java.util.ArrayList;
import java.util.List;

public interface AtmServiceRepository {

    void createAtmServices();

    List<AtmService> getAllAtmServices();

     // siia on vaja meetodit, mis tagastab kõik AtmService-d listina (entity) List<AtmServiceInfo>
     // mängime oma andmebaasi
}
