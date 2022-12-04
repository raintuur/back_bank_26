package ee.valiit.back_bank_26.business.atm;

import ee.valiit.back_bank_26.business.atm.dto.AtmRequest;
import ee.valiit.back_bank_26.domain.atm.location.LocationDto;
import ee.valiit.back_bank_26.domain.atm.option.OptionDto;
import ee.valiit.back_bank_26.domain.city.CityDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;


// @RestController annab Springile märku, et siin klassis on mingid endpoint'id (controllerid)
@RestController

//  @RequestMapping'uga saab defineerida mingi pathi (raja) osa,
//  mis on iga SIIN KLASSIS oleva endpointi (controlleri) raja osa
//  ehk siis http://localhost:8080/atm
@RequestMapping("/atm")
public class BankAtmController {
    // Kui meie veebirakendus tõmmatakse käima, siis taustal toimetab servlet dispatcher,
    // kes teab kõiki meie controllerite endpoinide definitsioone
    // Kui see teema on veel endiselt segane, siis palun vaata uuesti "Spring HelloWorld":
    // https://youtu.be/pc9irBCk6rg

    // @Resource abiga saab Spring teha meile ligipääsu:
    // @Service, @Component, @Mapper, @Repository, jne annotatsiooniga klassidele
    @Resource
    private BankAtmService bankAtmService;

    // Kui meie veebiserverisse tuleb sisse http päring 'GET' 'http://localhost:8080/atm/city'
    // siis käivitatakse selle mäppingu all olev meetod getAllCities()
    // Kuna getAllCities() meetod, on defineeritud nii, et see tagastab List<CityDto> tüüpi objekti,
    // siis RETURN'is peab olema List<CityDto> tüüpi objekt (see vastus läheb serverist välja JSON sõnumina)

    // Kui HTTP sõnumite saatmise ja kättesaamise teema on veel endiselt segane, siis palun vaata uuesti "Spring HelloWorld":
    // https://youtu.be/pc9irBCk6rg
    // Kui JSON'i sõnumi struktuuri teema on veel endiselt segane, siis palun vaata uuesti "JSON":
    // https://youtu.be/dyZUWR3Cchw
    @GetMapping("/city")
    // @Operation lisab Swageri teenuse juurde vastavasisulise kirjelduse
    @Operation(summary = "Selle teenusega saad kätte kõik linnad", description = "Mingi pikem jutt rohkem mula")
    public List<CityDto> getAllCities() {
        // Siin meetodis pole mingeid parameetreid/andmeid, mis meetodi väljakutsumisel siia sisse kaasa tuleksid
        // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
        // https://youtu.be/EI3XfkdPBc4
        // https://youtu.be/GvP68LBZiUA
        // https://youtu.be/4ZkvNfu9kNw

        // Kutsume välja meie poolt defineeritud meetodi nimega getAllCities()
        // See meetod on meil ära defineeritud BankAtmService klassis
        // getAllCities() on meil selliselt defineeritud, et see võtab sisse parameetritena:
        // int tüüpi objekti
        // See on selleks vajalik, et me saaksime anda meetodisse kaasa anda objekti, kus sees on mingid andmed,
        // millega me soovime kuidagi toimetada.
        // bankAtmService.getAllCities() meetod on defineeritud nii, et see tagastab List<CityDto> tüüpi objekti
        // siin all me loome uue List<CityDto> tüüpi objekti 'result' mille sisse väärtustatakse
        // selle getAllCities() meetodi poolt tagastatav tulemus.
        // vaata ka kommentaare selle meetodi sees
        List<CityDto> result = bankAtmService.getAllCities();

        // http päringule tagastatakse 'result' objekt JSON'i kujul
        return result;
    }

    // Kui meie veebiserverisse tuleb sisse http päring 'GET' 'http://localhost:8080/atm/info/by-city?cityId=1'
    // siis käivitatakse selle mäppingu all olev meetod getAtmLocationsByCityId()
    // Kuna getAtmLocationsByCityId() meetod, on defineeritud nii, et see tagastab List<LocationDto> tüüpi objekti,
    // siis RETURN'is peab olema List<LocationDto> tüüpi objekt (see vastus läheb serverist välja JSON sõnumina)
    // Kuna meetodi parameetris on ära defineeritud @RequestParam int tüüpi objekt,
    // siis Spring eeldab, et http sõnumile antakse kaasa request parameeter 'cityId'
    // Kindlasti peab meetodi signatuuris olema ka see @RequestParam annotatsioon, sest muidu Spring ei tea,
    // et siia enpoint'ile peaks ka sisse tulema selline parameeter

    // Kui HTTP sõnumite saatmise ja kättesaamise teema on veel endiselt segane, siis palun vaata uuesti "Spring HelloWorld":
    // https://youtu.be/pc9irBCk6rg
    // Kui @RequestParam teema on veel endiselt segane, siis palun vaata uuesti "Spring @RequestParam":
    // https://youtu.be/9ovmRakMRBY
    // Kui JSON'i sõnumi struktuuri teema on veel endiselt segane, siis palun vaata uuesti "JSON":
    // https://youtu.be/dyZUWR3Cchw
    @GetMapping("/info/by-city")
    // @Operation lisab Swageri teenuse juurde vastavasisulise kirjelduse
    @Operation(summary = "Leiab pangaautomaatide asukohad linna ID'de järgi")
    public List<LocationDto> getAtmLocationsByCityId(@RequestParam Integer cityId) {
        // Võtame getAtmLocationsByCityId() signatuuri parameetris sisse int tüüpi väärtuse
        // Siin signatuuris antakse sellele objektidele nimeks 'cityId'
        // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
        // https://youtu.be/EI3XfkdPBc4
        // https://youtu.be/GvP68LBZiUA
        // https://youtu.be/4ZkvNfu9kNw

        // Kutsume välja meie poolt defineeritud meetodi nimega getAtmLocationsByCityId()
        // See meetod on meil ära defineeritud BankAtmService klassis
        // getAtmLocationsByCityId() on meil selliselt defineeritud, et see võtab sisse parameetritena:
        // int tüüpi objekti
        // See on selleks vajalik, et me saaksime anda meetodisse kaasa anda objekti, kus sees on mingid andmed,
        // millega me soovime kuidagi toimetada.
        // bankAtmService.getAtmLocationsByCityId() meetod on defineeritud nii, et see tagastab List<LocationDto> tüüpi objekti
        // siin all me loome uue List<LocationDto> tüüpi objekti 'result' mille sisse väärtustatakse
        // selle getAtmLocationsByCityId() meetodi poolt tagastatav tulemus.
        // vaata ka kommentaare selle meetodi sees
        List<LocationDto> result = bankAtmService.getAtmLocationsByCityId(cityId);

        // http päringule tagastatakse 'result' objekt JSON'i kujul
        return result;
    }

    // Kui meie veebiserverisse tuleb sisse http päring 'POST' 'http://localhost:8080/atm'
    // siis käivitatakse selle mäppingu all olev meetod addAtm()
    // Kuna addAtm() meetod, on defineeritud nii, et see on 'void', siis see meetod mingit JSON'it ei tagasta
    // Välja saadetakse vaid status code (kui kõik läheb hästi, siis on selleks koodiks 200).
    // Kuna meetodi parameetris on ära defineeritud @RequestBody AtmRequest tüüpi objekt,
    // siis Spring annab endast parima, et mäppida ära sisse tulev JSON sõnum selleks Java AtmRequest tüüpi objektiks
    // Swaggeri'is on olemas ka request body näidis sellisest JSON'ist, mille Spring peaks suutma ära mäppida:
    //    {
    //        "locationId": 0,
    //        "serialNumber": "string",
    //        "status": "string",
    //        "options": [
    //            {
    //                "optionId": 0,
    //                    "optionName": "string",
    //                    "isSelected": true
    //            }
    //        ]
    //    }
    // @RequestBody annotatsiooni lisamisel peaks jälgima seda, et see imporditakse "springframework" teegist
    // Kui @RequestBody teema on veel endiselt segane, siis palun vaata uuesti "Spring @RequestBody":
    // https://youtu.be/mIYDl4pf1P0
    // @Valid - annotatsioon kontrollib, et kas sissetulev JSON sõnum vastab sellistele nõuetele,
    // nagu on AtmRequest klassis muutujate peal defineeritud. Vaata ka AtmRequest klass sees olevaid kommentaare
    // Kui JSON'i sõnumi struktuuri teema on veel endiselt segane, siis palun vaata uuesti "JSON":
    // https://youtu.be/dyZUWR3Cchw
    @PostMapping()
    @Operation(summary = "Pangaautomaadi lisamine asukohta")
    public void addAtm(@RequestBody @Valid AtmRequest request) {
        // Võtame addAtm() signatuuri @RequestBody parameetris sisse AtmRequest tüüpi objekti,
        // Selle väärtused võetakse JSON sõnumist
        // Siin signatuuris antakse sellele objektile/muutujale nimeks 'request'


        // Kutsume välja meie poolt defineeritud meetodi bankAtmService.addAtm()
        // See meetod on meil ära defineeritud BankAtmService klassis
        // bankAtmService.addAtm() on meil selliselt defineeritud, et see võtab sisse parameetritena: AtmRequest tüüpi objekti
        // See on selleks vajalik, et me saaksime sellesse meetodisse kaasa anda objekti (andmed),
        // millega me soovime siis seal meetodi sees kuidagi toimetada.
        // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
        // https://youtu.be/EI3XfkdPBc4
        // https://youtu.be/GvP68LBZiUA
        // https://youtu.be/4ZkvNfu9kNw
        // vaata ka kommentaare selle 'bankAtmService.addAtm()' meetodi sees
        bankAtmService.addAtm(request);
    }


    @GetMapping("/option")
    @Operation(summary = "Leiab kõik automaatide võimalikud valikud (sularaha välja, sulraha sisse, jne)")
    public List<OptionDto> getAllAtmOptions() {
        List<OptionDto> result = bankAtmService.getAllAtmOptions();
        return result;
    }

    @GetMapping("/info")
    @Operation(summary = "Leiab kõikide pangaautomaatide asukohad")
    public List<LocationDto> getAllAtmLocations() {
        List<LocationDto> result = bankAtmService.getAllAtmLocations();
        return result;
    }



}
