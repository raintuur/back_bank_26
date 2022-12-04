package ee.valiit.back_bank_26.domain.userrole.user;

import ee.valiit.back_bank_26.validation.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

// @Service annab Springile märku, et see on teenuse tüüpi klass
// Nii saame hiljem @Resource abil siin klassis olevatele meetoditele mugavalt ligi
@Service
public class UserService {

    // @Resource abiga saab Spring teha meile ligipääsu:
    // @Service, @Component, @Mapper, @Repository, jne annotatsiooniga klassidele
    @Resource
    private UserRepository userRepository;


    // See meetod on defineeritud nii, et ta võtab sisse String tüüpi objektid
    // See on selleks vajalik, et me saaksime siin meetodis nende objektide andmetega kuidagi toimetada.
    // See meetod peab tagastama User tüüpi objekti
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public User getUserBy(String username, String password) {
        // Võtame login() signatuuri parameetris sisse String tüüpi objektid
        // Siin signatuuris antakse sellele objekti muutujale nimeks 'username' ja 'password'


        // kasutame userRepository (värav) objekti, et saada ligi tabeli 'user' andmetele
        // see meetod findById() on juba JpaRepository klassis endal olemas.
        // Seda meetodit findById() me ei ole ise kuidagi loonud.
        // Kaasa anname konkreetse teenuse id ("Sularaha sisse", "Sularaha välja") - user tabeli veeru 'id' väärtuse.
        // repository tagastab antud 'id'le kuuluva user objekti (andmebaasi mõttes tagastatakse antud kliendi andmetega rida)
        // Tulemus mähitakse omakorda "Optional" klassi objekti sisse (komm ja kommipaber)
        // Sellel Optional klassil on olemas mugavad meetodid, millega saab kontrollida, et kas leiti mingi tulemus (user objekt pole 'null'
        // või siis ei leitud mingit tulemust.
        Optional<User> userOptional = userRepository.findBy(username, password);

        // Kutsume välja Validation klassi staatilise meetodi validateUserCredentials().
        // Pane tähele, siis ei ole pöördutud mingi klassi objekti poole vaid on pöördutud otse klassi enda poole
        // (Validation algab siin suure tähega, see ei ole mingi objekt)
        // Kaasa anname eelnevalt leitud 'userOptional' objekti
        // vaata ka kommentaare selle 'Validation.validateUserCredentials()' meetodi sees
        // Kui validateUserCredentials()'st visatakse ülesse viga, siis siit allapoole kood enam edasi ei lähe
        Validation.validateUserCredentials(userOptional);

        // meetodiga .get() võtame selle objekti sealt optional klassi seest välja (võtame kommi paberist välja)
        User user = userOptional.get();

        // RETURN'iga tagastatakse tulemus sinna kohta, kust see meetod välja kutsutakse
        return user;
    }


    public User getUserBy(Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
        return user;
    }

    public void addUserPhoto(User user, String pictureData) {
        byte[] pictureAsByteArray = pictureData.getBytes(StandardCharsets.UTF_8);
        user.setPictureData(pictureAsByteArray);
        userRepository.save(user);
    }
}
