package ee.valiit.back_bank_26.atm.option;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AtmServiceMapper {


    @Mapping(source = "id", target = "serviceId")
    @Mapping(source = "name", target = "serviceName")
    AtmServiceDto toDto(AtmService atmService);

    List<AtmServiceDto> toDtos(List<AtmService> atmServices);

}
