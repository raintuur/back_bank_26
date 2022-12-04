package ee.valiit.back_bank_26.domain.atm.location;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

// @Service annab Springile märku, et see on teenuse tüüpi klass
// Nii saame hiljem @Resource abil siin klassis olevatele meetoditele mugavalt ligi
@Service
public class LocationService {

    // @Resource abiga saab Spring teha meile ligipääsu:
    // @Service, @Component, @Mapper, @Repository, jne annotatsiooniga klassidele
    @Resource
    private LocationRepository locationRepository;

    public List<Location> findAll() {
        List<Location> locations = locationRepository.findAll();
        return locations;
    }

    // See meetod on defineeritud nii, et ta võtab sisse Integer tüüpi objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod peab tagastama List<Location> tüüpi objekti
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public List<Location> findLocationsBy(Integer cityId) {
        // Võtame findLocationsBy() signatuuri parameetris sisse Integer tüüpi objekti
        // Siin signatuuris antakse sellele objekti muutujale nimeks 'cityId'


        // kasutame locationRepository (värav) objekti, et saada ligi tabeli 'location' andmetele
        // See meetod findLocationsBy() on meie enda loodud meetod.
        // Kaasa anname  konkreetse linna id (cityId) ehk 'location' tabeli veeru 'id' väärtuse.
        // repository tagastab antud 'id'le kuuluva location objekti (andmebaasi mõttes tagastatakse antud kliendi andmetega rida)
        // Tulemus pannakse omakorda "List" klassi locations objekti sisse
        // Vaata ka kommentaare selle meetodi sees.
        List<Location> locations = locationRepository.findLocationsBy(cityId);

        // RETURN'iga tagastatakse tulemus sinna kohta, kust see meetod välja kutsutakse
        return locations;
    }

    public Location findById(Integer locationId) {
        // Võtame findById() signatuuri parameetris sisse Integer tüüpi objekti
        // Siin signatuuris antakse sellele objekti muutujale nimeks 'locationId'


        // kasutame locationRepository (värav) objekti, et saada ligi tabeli 'location' andmetele
        // see meetod findById() on juba JpaRepository klassis endal olemas.
        // Seda meetodit findById() me ei ole ise kuidagi loonud.
        // Kaasa anname asukoha id - 'location' tabeli veeru 'id' väärtuse.
        // repository tagastab antud 'id'le kuuluva location objekti (andmebaasi mõttes tagastatakse asukoha andmetega rida)
        // Tulemus mähitakse omakorda "Optional" klassi objekti sisse (komm ja kommipaber)
        // Sellel Optional klassil on olemas mugavad meetodid, millega saab kontrollida, et kas leiti mingi tulemus (user objekt pole 'null'
        // või siis ei leitud mingit tulemust.
        // meetodiga .get() siin meetodi lõpus võtame selle objekti sealt optional klassi seest välja (võtame kommi paberist välja)
        Location location = locationRepository.findById(locationId).get();

        // RETURN'iga tagastatakse tulemus sinna kohta, kust see meetod välja kutsutakse
        return location;
    }
}
