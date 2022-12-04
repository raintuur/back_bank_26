package ee.valiit.back_bank_26.domain.atm.option;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

// @Service annab Springile märku, et see on teenuse tüüpi klass
// Nii saame hiljem @Resource abil siin klassis olevatele meetoditele mugavalt ligi
@Service
public class OptionService {

    // @Resource abiga saab Spring teha meile ligipääsu:
    // @Service, @Component, @Mapper, @Repository, jne annotatsiooniga klassidele
    @Resource
    private OptionRepository optionRepository;

    public List<Option> findAll() {
        List<Option> entities = optionRepository.findAll();
        return entities;
    }

    public Option findById(Integer optionId) {
        // Võtame findById() signatuuri parameetris sisse Integer tüüpi objekti
        // Siin signatuuris antakse sellele objekti muutujale nimeks 'optionId'


        // kasutame optionRepository (värav) objekti, et saada ligi tabeli 'option' andmetele
        // see meetod findById() on juba JpaRepository klassis endal olemas.
        // Seda meetodit findById() me ei ole ise kuidagi loonud.
        // Kaasa anname konkreetse teenuse id ("Sularaha sisse", "Sularaha välja") - option tabeli veeru 'id' väärtuse.
        // repository tagastab antud 'id'le kuuluva option objekti (andmebaasi mõttes tagastatakse antud kliendi andmetega rida)
        // Tulemus mähitakse omakorda "Optional" klassi objekti sisse (komm ja kommipaber)
        // Sellel Optional klassil on olemas mugavad meetodid, millega saab kontrollida, et kas leiti mingi tulemus (customer objekt pole 'null'
        // või siis ei leitud mingit tulemust.
        Optional<Option> optionalOption = optionRepository.findById(optionId);

        // meetodiga .get() võtame selle objekti sealt optional klassi seest välja (võtame kommi paberist välja)
        Option optionEntity = optionalOption.get();

        // RETURN'iga tagastatakse tulemus sinna kohta, kust see meetod välja kutsutakse
        return optionEntity;
    }
}
