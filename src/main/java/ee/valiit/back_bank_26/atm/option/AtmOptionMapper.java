package ee.valiit.back_bank_26.atm.option;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AtmOptionMapper {

    @Mapping(source = "id", target = "serviceId")
    @Mapping(source = "name", target = "serviceName")
    AtmOptionDto toDto(AtmOption atmOption);

    List<AtmOptionDto> toDtos(List<AtmOption> atmOption);

}
