package ee.valiit.back_bank_26.domain.atm.atm;

import ee.valiit.back_bank_26.bussiness.atm.AtmRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AtmMapper {

    @Mapping(target = "serialNumber", source = "serialNumber")
    @Mapping(target = "status", source = "status")
    Atm atmRequestToEntity(AtmRequest atmRequest);
}
