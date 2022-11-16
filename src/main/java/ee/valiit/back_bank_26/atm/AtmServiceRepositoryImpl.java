package ee.valiit.back_bank_26.atm;

import java.util.ArrayList;
import java.util.List;

public class AtmServiceRepositoryImpl implements AtmServiceRepository {

    private static List<AtmService> atmServices = new ArrayList<>();

    @Override
    public void createAtmServices() {

        AtmService atmService1 = new AtmService(1, "Raha sisse");
        AtmService atmService2 = new AtmService(2, "Raha välja");
        AtmService atmService3 = new AtmService(3, "Maksed");
        atmServices.add(atmService1);
        atmServices.add(atmService2);
        atmServices.add(atmService3);

    }

    @Override
    public List<AtmService> getAllAtmServices() {

        return atmServices;
    }
}
