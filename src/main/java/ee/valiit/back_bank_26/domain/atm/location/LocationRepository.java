package ee.valiit.back_bank_26.domain.atm.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    @Query("select l from Location l where l.city.id = :cityId order by l.name")
    List<Location> findLocationsBy(@Param("cityId") Integer cityId);

}