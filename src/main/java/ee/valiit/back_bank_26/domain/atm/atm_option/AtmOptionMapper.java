package ee.valiit.back_bank_26.domain.atm.atm_option;

import ee.valiit.back_bank_26.bussiness.atm.AtmLocationInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AtmOptionMapper  {

    @Mapping(source = "atm.location.city.name", target = "cityName")
    @Mapping(source = "atm.location.name", target = "locationName")

   AtmLocationInfo toLocationInfo(AtmOption atmOption );

}
