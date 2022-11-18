package ee.valiit.back_bank_26.atm.option;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OptionMapper {

    OptionDto optionToOptionDto(Option option);

}
