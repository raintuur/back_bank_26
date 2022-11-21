package ee.valiit.back_bank_26.domain.atm.option;

import ee.valiit.back_bank_26.atm.AtmOptionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OptionMapper {
    @Mapping(source = "id", target = "optionId")
    @Mapping(source = "name", target = "optionName")
    @Mapping(constant = "false", target = "isSelected")
    OptionDto toDto(Option option);

    List<OptionDto> toDtos(List<Option> options);

    @Mapping(source = "name", target = "optionName")
    AtmOptionDto toAtmOptionDto(Option option);

    List<AtmOptionDto> toAtmOptionDtos(List<Option> options);

}
