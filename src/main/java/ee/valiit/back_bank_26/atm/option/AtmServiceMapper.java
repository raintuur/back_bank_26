package ee.valiit.back_bank_26.atm.option;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AtmServiceMapper {

    @Mapping(source = "id",target = "serviceId")
    @Mapping(source = "name",target = "serviceName")
    AtmServiceDto toDto(AtmService atmService);

    List<AtmServiceDto> toDtos(List<AtmService> atmServices);




//    @Mapping(source = "serviceId", target = "id")
//    @Mapping(source = "serviceName", target = "name")
//    AtmService atmServiceDtoToAtmService(AtmServiceDto atmServiceDto);
//
//    @InheritInverseConfiguration(name = "atmServiceDtoToAtmService")


//    @InheritConfiguration(name = "atmServiceDtoToAtmService")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    AtmService updateAtmServiceFromAtmServiceDto(AtmServiceDto atmServiceDto, @MappingTarget AtmService atmService);
}
