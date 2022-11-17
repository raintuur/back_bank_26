package ee.valiit.back_bank_26.atm;

import java.util.List;

public interface ServiceNameMapper {

    ServiceNameDto serviceNameToServiceNameDto(AtmService atmService);

    List<ServiceNameDto> serviceNamesDto(List<AtmService> atmServices);

}
