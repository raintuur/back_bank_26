package ee.valiit.back_bank_26.domain.userrole.user;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link ee.valiit.back_bank_26.domain.userrole.UserRole} entity
 */
@Data
public class LoginResponse implements Serializable {
    private final Integer userId;
    private final Integer roleId;
    @Size(max = 50)
    @NotNull
    private final String roleType;
}