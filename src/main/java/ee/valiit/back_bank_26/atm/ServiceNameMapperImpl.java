package ee.valiit.back_bank_26.atm;

import java.util.ArrayList;
import java.util.List;

public class ServiceNameMapperImpl implements ServiceNameMapper{

    private static List<ServiceNameDto> serviceNameDtos = new ArrayList<>();

    @Override
    public ServiceNameDto serviceNameToServiceNameDto(AtmService atmService) {
        ServiceNameDto serviceNameDto = new ServiceNameDto();
        serviceNameDto.setAtmServiceName(atmService.getName());
        return serviceNameDto;
    }

    @Override
    public List<ServiceNameDto> serviceNamesDto(List<AtmService> atmServices) {

        for (AtmService service : atmServices) {
            serviceNameDtos.add(service.getName())
        }

        return serviceNameDtos;
    }
}
