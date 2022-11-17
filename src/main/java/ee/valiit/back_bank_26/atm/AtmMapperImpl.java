package ee.valiit.back_bank_26.atm;

import java.util.ArrayList;
import java.util.List;

public class AtmMapperImpl implements AtmMapper {

    @Override
    public AtmServiceInfo atmServiceToAtmServiceInfo(AtmService atmService) {
        AtmServiceInfo info = new AtmServiceInfo();
        info.setServiceId(atmService.getId());
        info.setServiceName(atmService.getName());
        info.setIsSelected(false);
        return info;
    }

    @Override
    public List<AtmServiceInfo> atmServicesToAtmServiceInfos(List<AtmService> atmServices) {
        List<AtmServiceInfo> infos = new ArrayList<>();
//        atmServices.forEach();
        for (AtmService service : atmServices) {
            AtmServiceInfo info = atmServiceToAtmServiceInfo(service);
            infos.add(info);
        }
        return infos;
    }
}
