package ee.valiit.back_bank_26.domain.city;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

// @Service annab Springile märku, et see on teenuse tüüpi klass
// Nii saame hiljem @Resource abil siin klassis olevatele meetoditele mugavalt ligi
@Service
public class CityService {


    // @Resource abiga saab Spring teha meile ligipääsu:
    // @Service, @Component, @Mapper, @Repository, jne annotatsiooniga klassidele
    @Resource
    private CityRepository cityRepository;


    // See meetod on defineeritud nii, et ta ei võta väljapoolt sisse ühtegi parameetrit/andmeid/infot
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public List<City> findAll() {

        // kasutame cityRepository (värav) objekti, et saada ligi tabeli 'city' andmetele
        // Seda meetodit findAll() me ei ole ise kuidagi loonud.
        // see meetod findAll() on juba JpaRepository klassis endal olemas.
        // Vaata ka CityRepository klassi sees olevat infot
        // Tulemus pannakse omakorda "List" klassi allEntities objekti sisse
        List<City> allEntities = cityRepository.findAll();

        // RETURN'iga tagastatakse tulemus sinna kohta, kust see meetod välja kutsutakse
        return allEntities;
    }
}
