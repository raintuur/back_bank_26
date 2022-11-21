package ee.valiit.back_bank_26.domain.atm.atm_option;

import ee.valiit.back_bank_26.domain.atm.option.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AtmOptionRepository extends JpaRepository<AtmOption, Integer> {


//    @Query("select distinct a.option.name from AtmOption a where a.atm.location.id = ?1 order by a.option.name desc")
//    List<String> findAtmOptionNamesBy(Integer locationId);

    @Query("select distinct a.option from AtmOption a where a.atm.location.id = ?1")
    List<Option> findOptionsBy(Integer locationId);





}