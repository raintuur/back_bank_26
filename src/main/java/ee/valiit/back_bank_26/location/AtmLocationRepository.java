package ee.valiit.back_bank_26.location;

import java.util.List;

public interface AtmLocationRepository {

    void createAtmLocationRepository();

    List<Location> findAllAtmLocations();

}
