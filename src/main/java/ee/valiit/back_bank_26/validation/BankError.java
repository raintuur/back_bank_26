package ee.valiit.back_bank_26.validation;

import lombok.Getter;
import lombok.Setter;

@Getter

public enum BankError {
    INCORRECT_CREDENTIALS("Sellist kasutajanime või parooli ei leitud", "666"),
    INSUFFICIENT_FUNDS("Ebapiisavad vahendid", "000");

    private final String message;
    private final String errorCode;

    BankError(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}