package ee.valiit.back_bank_26.domain.atm.atm;

import ee.valiit.back_bank_26.business.atm.AtmRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AtmMapper {

    Atm toEntity(AtmRequest request);
}
