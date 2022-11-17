package ee.valiit.back_bank_26.atm;

import java.util.List;

public interface AtmMapper {

    AtmServiceInfo atmServiceToAtmServiceInfo(AtmService atmService);

    List<AtmServiceInfo> atmServicesToAtmServiceInfos(List<AtmService> atmServices);

}
