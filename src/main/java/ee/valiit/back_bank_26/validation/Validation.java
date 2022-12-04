package ee.valiit.back_bank_26.validation;

import ee.valiit.back_bank_26.domain.userrole.user.User;
import ee.valiit.back_bank_26.infrastructure.exception.BusinessException;

import java.util.Optional;

public class Validation {


    // See meetod on defineeritud staatilise meetodina. See tähendab seda, et seda meetodit on võimalik välja kutsuda
    // ilma, et peaks enne sellest klassist tegema objekti.
    // Staatilist meetodit saab välja kutsuda kirjutades välja klassi nime ja siis meetodi nime (Validation.validateUserCredentials())
    // Eelduseks on see, et siin meetodis ei kasutada kuidagi klassi instantsi muutujaid
    // (nt. private String name, private int age, vms)
    // Sest kui me kutsuksime selle meetodi klassi nime abil staatiliselt välja,
    // siis sellest klassist me ju objekti ei tee ning neid välju ei väärtusta
    // seega jääks selle klassi intsantsi muutujate väärtused null'ideks ning nendega ei oleks siis võimaluk kuidagi toimetada.
    // See meetod on defineeritud nii, et ta võtab sisse Optional<User> tüüpi objekti
    public static void validateUserCredentials(Optional<User> userOptional) {
        // Võtame validateUserCredentials() signatuuri parameetris sisse Optional<User> tüüpi objekti
        // Siin signatuuris antakse selle objekti muutuja nimeks 'userOptional'

        // userOptional objekti klassi  tüüp on OOptional<User>
        // Siin 'if' lause sees kasutatakse Optional klassi meetodit isEmpty(),
        // mis tagastab 'true' kui selle Optional klassi sisse mähitud objekti väärtus on 'null'
        if (userOptional.isEmpty()) {

            // Kui if lause sisu rehtkendus true-ks, siis tuldi siia sisse, et visata süsteemis ülesse viga
            // vigu saame visata ülesse kasutades võtme sõnu "throw new ..."
            // vaata ka nende klasside BusinessException ja BankError sisse
            throw new BusinessException(BankError.INCORRECT_CREDENTIALS.getMessage(), BankError.INCORRECT_CREDENTIALS.getErrorCode() );
        }
    }

}
