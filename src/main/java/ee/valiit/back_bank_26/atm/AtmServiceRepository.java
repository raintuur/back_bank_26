package ee.valiit.back_bank_26.atm;

import java.util.ArrayList;
import java.util.List;

public interface AtmServiceRepository {

    void createAtmServices();

    List<AtmService> getAllAtmServices();

}

