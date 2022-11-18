package ee.valiit.back_bank_26.domain.atm.atm_option;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AtmOptionRepository extends JpaRepository<AtmOption, Integer> {

    @Query("select a from AtmOption a where a.atm.location.id = ?1 order by a.atm.location.id, a.option.id")
    List<AtmOption> findAtmOptionsBy(Integer locationId);



}