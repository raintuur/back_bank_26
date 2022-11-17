package ee.valiit.back_bank_26.atm;

import java.util.List;

public interface AtmMapper {

    AtmServiceInfo AtmServiceToAtmServiceInfo(AtmService atmService);

    List<AtmServiceInfo> AtmServicesToAtmServiceInfos(List<AtmService> atmServices);
}
