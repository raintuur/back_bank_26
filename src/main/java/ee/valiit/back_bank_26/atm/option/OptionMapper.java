package ee.valiit.back_bank_26.atm.option;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OptionMapper {
    @Mapping(source = "optionId", target = "id")
    @Mapping(source = "optionName", target = "name")
    Option optionDtoToOption(OptionDto optionDto);

    @InheritInverseConfiguration(name = "optionDtoToOption")
    OptionDto toDto(Option option);

    @InheritConfiguration(name = "optionDtoToOption")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Option updateOptionFromOptionDto(OptionDto optionDto, @MappingTarget Option option);

    List<OptionDto> toDtos(List<Option> options);
}
