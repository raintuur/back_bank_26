package ee.valiit.back_bank_26.infrastructure.error;

import lombok.Data;

@Data
public class ApiError {
    private String message;
    private String errorCode;
}

