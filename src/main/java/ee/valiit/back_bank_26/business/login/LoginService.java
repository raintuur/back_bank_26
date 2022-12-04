package ee.valiit.back_bank_26.business.login;

import ee.valiit.back_bank_26.domain.userrole.user.User;
import ee.valiit.back_bank_26.domain.userrole.user.UserMapper;
import ee.valiit.back_bank_26.domain.userrole.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

// @Service annab Springile märku, et see on teenuse tüüpi klass
// Nii saame hiljem @Resource abil siin klassis olevatele meetoditele mugavalt ligi
@Service
public class LoginService {

    // @Resource abiga saab Spring teha meile ligipääsu:
    // @Service, @Component, @Mapper, @Repository, jne annotatsiooniga klassidele
    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    // See meetod on defineeritud nii, et ta võtab sisse String tüüpi objektid
    // See on selleks vajalik, et me saaksime siin meetodis nende objektide andmetega kuidagi toimetada.
    // See meetod peab tagastama LoginResponse tüüpi objekti
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public LoginResponse login(String username, String password) {
        // Võtame login() signatuuri parameetris sisse String tüüpi objektid
        // Siin signatuuris antakse sellele objekti muutujale nimeks 'username' ja 'password'

        // Kutsume välja meie poolt defineeritud meetodi userService.getUserBy()
        // See meetod on meil ära defineeritud UserService klassis
        // userService.getUserBy() on meil selliselt defineeritud, et see võtab sisse parameetritena: String tüüpi objektid
        // Parameetrid on selleks vajalikud, et me saaksime meetodisse kaasa anda mingi objektid (andmed),
        // millega me soovime siis seal meetodi sees kuidagi toimetada.
        // Seega kuna meil on siin mingeid andmeid, mida mida väljakutsutav meetod vajab, siis me peame väljakutsumisel need kenasti kaasa andma.
        // userService.getUserBy() meetod on defineeritud nii, et see tagastab LoginResponse tüüpi objekti
        // Pane tähele, et hetkel me asume business kihi service sees ja siit klassis me ei pöördu otse repository-de vastu,
        // vaid läheme läbi domain kihis asuva service
        // Ehk siis me lähme toome info ära
        //      MingiÄriController -> MingiÄriService -> MingiEntityService -> MingiEntityRepository ja saam kätte info kätte entiry objektidena
        // Kui 3 kihiline arhidektuuri teema on veel endiselt segane, siis palun vaata uuesti "GetMapping-Resource-Service-JSON" video.
        // NB! Seal videos veidi triviaalsem näide ja pole seda MingiEntityService osa.
        // https://youtu.be/2tB5ybhPGgk
        // vaata ka kommentaare selle 'userService.getUserBy()' meetodi sees
        // Tulemus pannakse user objekti sisse.
        User user = userService.getUserBy(username, password);

        // (Entity -> Dto)
        // Siin vaatleme kõigepealt paremat poolt. Kutsutakse välja meetod toLoginResponse(), mis on defineeritud UserMapper klassis
        // toLoginResponse() on põhimõtteliselt mäpper meetod "Entity -> Dto"
        // toLoginResponse võtab parameetrina Entity (andmebaasi tabeli jaoks mõeldud klass) klassi tüüpi objekti
        // ja tagastab -> Dto (Data Transfer Object - andmete liigutamiseks mõeldud klass)
        // toLoginResponse() poolt tagastatud tulemus tagastatakse returniga
        // vaata ka kommentaare selle 'userMapper.toLoginResponse()' meetodi sees
        LoginResponse loginResponse = userMapper.toLoginResponse(user);

        // RETURN'iga tagastatakse tulemus sinna kohta, kust see meetod välja kutsutakse
        return loginResponse;
    }
}
