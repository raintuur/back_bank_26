package ee.valiit.back_bank_26.atm;

import java.util.ArrayList;
import java.util.List;

public class AtmMapperImpl implements AtmMapper{
    @Override
    public AtmServiceInfo AtmServiceToAtmServiceInfo(AtmService atmService) {

        AtmServiceInfo info = new AtmServiceInfo();
        info.setServiceId(atmService.getId());
        info.setServiceName(atmService.getName());
        info.setIsSelected(false);

        return info;
    }

    @Override
    public List<AtmServiceInfo> AtmServicesToAtmServiceInfos(List<AtmService> atmServices) {

        List<AtmServiceInfo> infos = new ArrayList<>();

        for (AtmService service : atmServices) {
            AtmServiceInfo info = AtmServiceToAtmServiceInfo(service);
            infos.add(info);
        }

        return infos;
    }
}
