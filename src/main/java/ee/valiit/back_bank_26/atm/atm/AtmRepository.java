package ee.valiit.back_bank_26.atm.atm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AtmRepository extends JpaRepository<Atm, Integer> {
}