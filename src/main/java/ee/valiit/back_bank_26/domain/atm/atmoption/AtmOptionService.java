package ee.valiit.back_bank_26.domain.atm.atmoption;

import ee.valiit.back_bank_26.domain.atm.option.Option;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

// @Service annab Springile märku, et see on teenuse tüüpi klass
// Nii saame hiljem @Resource abil siin klassis olevatele meetoditele mugavalt ligi
@Service
public class AtmOptionService {

    // @Resource abiga saab Spring teha meile ligipääsu:
    // @Service, @Component, @Mapper, @Repository, jne annotatsiooniga klassidele
    @Resource
    private AtmOptionRepository atmOptionRepository;


    // See meetod on defineeritud nii, et ta võtab sisse Integer tüüpi objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod peab tagastama List<Option> tüüpi objekti
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public List<Option> findOptionsBy(Integer locationId) {

        // kasutame atmOptionRepository (värav) objekti, et saada ligi tabeli 'location' andmetele
        // See meetod findLocationsBy() on meie enda loodud meetod.
        // Kaasa anname  konkreetse linna id (locationId) ehk 'location' tabeli veeru 'id' väärtuse.
        // repository tagastab antud 'locationId'le kuuluvad Option objektid (andmebaasi mõttes tagastatakse antud asukoha pangaautomaadi teenused "Sularaha sisse", "Sularaha välja", jne)
        // Tulemus pannakse omakorda "List" klassi options objekti sisse
        // Vaata ka kommentaare selle meetodi sees.
        List<Option> options = atmOptionRepository.findOptionsBy(locationId);
        return options;
    }

    public void addAtmOption(AtmOption atmOption) {
        atmOptionRepository.save(atmOption);
    }
}
