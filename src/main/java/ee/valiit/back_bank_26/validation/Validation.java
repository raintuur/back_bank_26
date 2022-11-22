package ee.valiit.back_bank_26.validation;

import ee.valiit.back_bank_26.domain.userrole.user.User;
import ee.valiit.back_bank_26.infrastructure.exception.BusinessException;

import java.util.Optional;

public class Validation {

    public static void validateUserCredentials(Optional<User> userOptional) {
        if (userOptional.isEmpty()) {
            throw new BusinessException(
                    BankError.INCORRECT_CREDENTIALS.getMessage(),
                    BankError.INCORRECT_CREDENTIALS.getErrorCode());
        }
    }
}
