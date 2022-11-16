package ee.valiit.back_bank_26.atm;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtmServiceDto {
        private Integer serviceId;
        private String serviceName;
        private Boolean isSelected;
}
