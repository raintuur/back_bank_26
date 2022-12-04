package ee.valiit.back_bank_26.domain.atm;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

// @Service annab Springile märku, et see on teenuse tüüpi klass
// Nii saame hiljem @Resource abil siin klassis olevatele meetoditele mugavalt ligi
@Service
public class AtmService {

    // @Resource abiga saab Spring teha meile ligipääsu:
    // @Service, @Component, @Mapper, @Repository, jne annotatsiooniga klassidele
    @Resource
    private AtmRepository atmRepository;

    // See meetod on defineeritud nii, et ta võtab sisse Atm objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod peab tagastama Atm tüüpi objekti
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public void addAtm(Atm atm) {
        // Võtame addAtm() signatuuri parameetris sisse Atm tüüpi objekti
        // Siin signatuuris antakse sellele objekti muutujale nimeks 'atm'

        // kasutame atmRepository (värav) objekti, et saada ligi tabeli 'atm' andmetele
        // see meetod save() on juba JpaRepository klassis endal olemas.
        // Seda meetodit save() me ei ole ise kuidagi loonud.
        // Kaasa anname vastava tabeli entity ja sellega salvestatakse andmed andmebaasi kenast ka maha.
        atmRepository.save(atm);
    }
}
