package ee.valiit.back_bank_26.domain.atm;

import ee.valiit.back_bank_26.business.atm.dto.AtmRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AtmMapper {

    Atm toEntity(AtmRequest request);
}
