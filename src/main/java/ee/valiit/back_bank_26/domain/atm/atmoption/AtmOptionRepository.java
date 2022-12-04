package ee.valiit.back_bank_26.domain.atm.atmoption;

import ee.valiit.back_bank_26.domain.atm.option.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AtmOptionRepository extends JpaRepository<AtmOption, Integer> {

    @Query("select distinct (a.option) from AtmOption a where a.atm.location.id = ?1")
    List<Option> findOptionsBy(Integer locationId);

}