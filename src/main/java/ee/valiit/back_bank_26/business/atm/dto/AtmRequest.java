package ee.valiit.back_bank_26.business.atm.dto;

import ee.valiit.back_bank_26.domain.atm.option.OptionDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


// @Data on teegi Lombok annotatsioon. See annotatsioon lisab ja implemetneerib kompileerimise hektel ära
// meetodid Getter, Setter, RequiredArgsConstructor, ToString, EqualsAndHashCode
@Data
public class AtmRequest {

    // @NotNull valideerib ära, et see või olla null
    @NotNull
    private Integer locationId;

    // @Size valideerib ära, et selle välja stringi pikkus oleks vahemikus 1 -> 10 tähemärki
    @Size(min = 1, max = 10)
    private String serialNumber;
    private String status;
    private List<OptionDto> options;
}

