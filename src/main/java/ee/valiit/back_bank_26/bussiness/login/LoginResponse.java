package ee.valiit.back_bank_26.bussiness.login;

import ee.valiit.back_bank_26.domain.userrole.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse implements Serializable {
    private Integer userId;
    private Integer roleId;
    @Size(max = 50)
    @NotNull
    private String roleType;
}