package ee.valiit.back_bank_26.domain.atm.option;

import org.springframework.data.jpa.repository.JpaRepository;

// see on siin loodud üks uus interface.
// Me tegime selle IntelliJ abiga (parem klõps -> new -> Spring Data Repository)
// https://youtu.be/Z7I14OPQT-8
// See klass on klassi JpaRepository pikendus.
// See tähendab seda, et selles OptionRepository klassil on olemas kõik omadused ja meetodid,
// mis on olemas JpaRepository klassil.
// sinna JpaRepository klassi on kaasa antud ka entity klass Option.
// seal siis juba tekivad vastavad seosed ja võimalused, millega saame vastavale tabelile ligi.
public interface OptionRepository extends JpaRepository<Option, Integer> {

    /// värav andmebaasi konkreetse tabeli vastu (option)
    // siia klassi pole juurde lisatud ühtegi omaloodud meetodit
    // Vajadusel saab siia juurde lisada oma meetodeid
    // Vaata ka Create repository methods
    // https://youtu.be/kMR8PzaCp0Y
}