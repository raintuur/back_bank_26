package ee.valiit.back_bank_26.domain.atm.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Query("select l from Location l where l.city.id = ?1 order by l.name")
    List<Location> findLocationsBy(Integer cityId);

}