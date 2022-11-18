package ee.valiit.back_bank_26.domain.atm.atmoption;


import ee.valiit.back_bank_26.atm.AtmLocationInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AtmOptionMapper {

    @Mapping(source = "atm",target = "cityName")
    @Mapping(source = "",target = "locationName")
    @Mapping(source = "",target = "option")
    AtmLocationInfo toLocationResponse(AtmOption atmOption);
}
