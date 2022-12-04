package ee.valiit.back_bank_26.domain.atm.atmoption;

import ee.valiit.back_bank_26.domain.atm.option.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// see on siin loodud üks uus interface.
// Me tegime selle IntelliJ abiga (parem klõps -> new -> Spring Data Repository)
// https://youtu.be/Z7I14OPQT-8
// See klass on klassi JpaRepository pikendus.
// See tähendab seda, et selles AtmOptionRepository klassil on olemas kõik omadused ja meetodid,
// mis on olemas JpaRepository klassil.
// sinna JpaRepository klassi on kaasa antud ka entity klass AtmOption.
// seal siis juba tekivad vastavad seosed ja võimalused, millega saame vastavale tabelile ligi.
public interface AtmOptionRepository extends JpaRepository<AtmOption, Integer> {

    // Lisaks kõikidele meetoditele, mis tulevad out of the box JpaRepository-iga kaasa,
    // saab siia klassi ka ise andmebaasi päringute meetodeid juurde lisada.
    // Tähtis on teada, et kuidas JPA tehnoloogia oskab programmeerimise keelest tõlgendada SQL lauseid,
    // millega saab andmebaasis mingeid toiminguid teha.
    // JPA oskab SQL lauseid teha kas meetodi nime jörgi või siis  @Query() annotatsiooni sees oleva definitsiooni järgi.
    // Et meetodi nime järgi SQL lauset kokku panna, peab see nimi koosnema õiges järjekorras õigetest sõnadest.
    // Kui soovid mingit lihtsat oma väljamõeldud meetodi nime kasutada,
    // siis peab kindlasi sellel meetodil olema @Query() annotatsiooniga SQL lause definitsioon,
    // sest muidu, et oska JPA tehnoloogia õiget päringut kokku panna.
    // Õnneks saab nende meetodite koostamiseks kasutada IntelliJ pluginat JPA Buddy, mis teeb sellise meetodite lisamise väga lihtsaks.
    // Kui JPA JpaRepositor meetodite loomise teema on veel endiselt segane, siis palun vaata uuesti "Create repository methods"
    // https://youtu.be/kMR8PzaCp0Y
    @Query("select a from AtmOption a where a.atm.location.id = ?1 order by a.atm.location.id, a.option.id")
    List<AtmOption> findAtmOptionsBy(Integer locationId);

    @Query("select distinct (a.option) from AtmOption a where a.atm.location.id = ?1")
    List<Option> findOptionsBy(Integer locationId);



}