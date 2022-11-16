package ee.valiit.back_bank_26.atm;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// Dto
public class AtmServiceInfo {
    private Integer serviceId;
    private String serviceName;
    private Boolean isSelected;
}