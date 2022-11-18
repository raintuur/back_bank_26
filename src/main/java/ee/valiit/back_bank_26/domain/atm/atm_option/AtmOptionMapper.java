package ee.valiit.back_bank_26.domain.atm.atm_option;

import ee.valiit.back_bank_26.atm.AtmLocationInfo;
import ee.valiit.back_bank_26.domain.atm.atm_option.AtmOption;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AtmOptionMapper  {

    @Mapping(source = "atm.location.city.name", target = "cityName")
    @Mapping(source = "atm.location.name", target = "locationName")

    AtmLocationInfo toLocationInfo(AtmOption atmOption );

    List<AtmLocationInfo> toLocationInfos(List<AtmOption> atmOptions);

}
