package ee.valiit.back_bank_26.atm.option;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Integer> {

    /// värav andmebaasi konkreetse tabeli vastu (option)
}