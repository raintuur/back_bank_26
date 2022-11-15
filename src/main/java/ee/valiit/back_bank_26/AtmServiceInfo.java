package ee.valiit.back_bank_26;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtmServiceInfo {

    private Integer serviceId;
    private String serviceName;
    private Boolean isSelected = false;

}
