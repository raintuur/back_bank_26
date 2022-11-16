package ee.valiit.back_bank_26.atm;

import java.util.ArrayList;
import java.util.List;

public class AtmServiceMapperImpl implements AtmServiceMapper {


    @Override
    public AtmServiceDto atmServiceToAtmServiceDto(AtmService atmService) {
        AtmServiceDto atmServiceDto = new AtmServiceDto();
        atmServiceDto.setServiceId(atmService.getId());
        atmServiceDto.setServiceName(atmService.getName());
        atmServiceDto.setIsSelected(false);
        return atmServiceDto;
    }

    @Override
    public List<AtmServiceDto> atmServicesToAtmServicesDto(List<AtmService> serviceList) {
        List<AtmServiceDto> serviceDtoList = new ArrayList<>();

        for (AtmService atmService : serviceList) {
            serviceDtoList.add(atmServiceToAtmServiceDto(atmService));
        }
        return serviceDtoList;
    }
}
