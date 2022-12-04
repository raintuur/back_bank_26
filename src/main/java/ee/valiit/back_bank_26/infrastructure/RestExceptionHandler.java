package ee.valiit.back_bank_26.infrastructure;

import ee.valiit.back_bank_26.infrastructure.error.ApiError;
import ee.valiit.back_bank_26.infrastructure.exception.BusinessException;
import ee.valiit.back_bank_26.infrastructure.exception.DataNotFoundException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

// See klass on siin ise tehtud
// @ControllerAdvice hästi pealiskaudselt öeldes, annab see annotatsioon Springile märku,
// et me seadistame siin klassis mõningaid errori tagastamise asju RestControlleritele

// See klass siin pikendad

// See klass on klassi ResponseEntityExceptionHandler pikendus.
// ResponseEntityExceptionHandler klass on üks Springi raamistiku klassidest.
// See tähendab seda, et selles sellel meie loodid ResponseEntityExceptionHandler klassil
// on olemas kõik omadused ja meetodid, mis on olemas ResponseEntityExceptionHandler klassil.
// teatud veaolukordades üritab spring käivitada mõningaid meetodeid, mis asuvad selles ResponseEntityExceptionHandler klassis
// Siin klassis aga on need teatud meetodid (vt @Override meetodid siin klassis) meie enda lahendusega üle-kirjutad
// (st, me oleme siin ära defineerinud oma lahendused, mis siis käivituvad nende Springi meetodite lahenduste asemel.)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    // @ExceptionHandler'i annotatsiooni abil saame lahendada ära meie enda poolt loodud
    // exceptionite (DataNotFoundException ja BusinessException), käitumise, et mida siis tagastatakse JSON'is
    // Siin siis ei lahendata neid Exceptioneid, mida Spring ise viskab, vaid just meie enda loodud Exceptioneid
    @ExceptionHandler
    public ResponseEntity<ApiError> handleDataNotFoundException(DataNotFoundException exception) {
        // Siin me loome objekti klassist, mis hoiab vajalike andmeid, mida me soovime siis vea JSON'is hoida.
        // Vaata ka ApiError klassi sees olevaid kommentaare.
        // Setterite abil siis väärtustame väljad
        // Pane siia kuhugu üks breakpoint, pane debugger tööle, tekita viga ja vaata, kuidas tõesi kood jõuab siia.
        ApiError apiError = new ApiError();
        apiError.setMessage(exception.getMessage());
        apiError.setErrorCode(exception.getErrorCode());

        // Siin siis tagastamegi apiError objekti (millest tuleb JSON) ja siis päringu staatus
        // Me saame siin ise valida, et mis status siis selles erroris tagastatakse.
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> handleBusinessException(BusinessException exception) {
        ApiError apiError = new ApiError();
        apiError.setMessage(exception.getMessage());
        apiError.setErrorCode(exception.getErrorCode());
        return new ResponseEntity<>(apiError, HttpStatus.FORBIDDEN);
    }

    // Kui üleval eelnevad @ExceptionHandler'iga tähistatud meetodid sätestasid ära, mis infoga tagastada meie enda loodud Exceptionei
    // siis siin @Override'ga tähistatud meetodites, me sätestame ära need veaolukorrad
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiError apiError = new ApiError();
        apiError.setMessage("Invalid request body content.");
        apiError.setErrorCode(exception.getMessage());
        return handleExceptionInternal(exception, apiError, headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiError apiError = new ApiError();
        apiError.setMessage("Invalid parameter type.");
        apiError.setErrorCode(exception.getMessage());
        return handleExceptionInternal(exception, apiError, headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException exception, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        ApiError apiError = new ApiError();
        apiError.setMessage("Invalid request body content.");
        final List<String> errors = new ArrayList<>();
        for (final FieldError error : exception.getBindingResult().getFieldErrors()) {
            // default lahendus
            // errors.add(error.getField() + ": " + error.getDefaultMessage());
            errors.add(error.getDefaultMessage());
        }
        for (final ObjectError error : exception.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        apiError.setErrorCode(errors.toString());
        return handleExceptionInternal(exception, apiError, headers, HttpStatus.BAD_REQUEST, request);
    }

}
