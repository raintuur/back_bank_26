package ee.valiit.back_bank_26.atm;

import java.util.List;

public interface AtmServiceMapper {

    AtmServiceDto atmServiceToAtmServiceDto(AtmService atmService);

    List<AtmServiceDto> atmServicesToAtmServicesDto(List<AtmService> serviceList);


}
