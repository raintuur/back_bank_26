package ee.valiit.back_bank_26.business.atm;

import ee.valiit.back_bank_26.business.atm.dto.AtmOptionDto;
import ee.valiit.back_bank_26.business.atm.dto.AtmRequest;
import ee.valiit.back_bank_26.domain.atm.Atm;
import ee.valiit.back_bank_26.domain.atm.AtmMapper;
import ee.valiit.back_bank_26.domain.atm.AtmService;
import ee.valiit.back_bank_26.domain.atm.atmoption.AtmOption;
import ee.valiit.back_bank_26.domain.atm.atmoption.AtmOptionService;
import ee.valiit.back_bank_26.domain.atm.location.Location;
import ee.valiit.back_bank_26.domain.atm.location.LocationDto;
import ee.valiit.back_bank_26.domain.atm.location.LocationMapper;
import ee.valiit.back_bank_26.domain.atm.location.LocationService;
import ee.valiit.back_bank_26.domain.atm.option.Option;
import ee.valiit.back_bank_26.domain.atm.option.OptionDto;
import ee.valiit.back_bank_26.domain.atm.option.OptionMapper;
import ee.valiit.back_bank_26.domain.atm.option.OptionService;
import ee.valiit.back_bank_26.domain.city.City;
import ee.valiit.back_bank_26.domain.city.CityDto;
import ee.valiit.back_bank_26.domain.city.CityMapper;
import ee.valiit.back_bank_26.domain.city.CityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


// @Service annab Springile märku, et see on teenuse tüüpi klass
// Nii saame hiljem @Resource abil siin klassis olevatele meetoditele mugavalt ligi
@Service
public class BankAtmService {

    // @Resource abiga saab Spring teha meile ligipääsu:
    // @Service, @Component, @Mapper, @Repository, jne annotatsiooniga klassidele
    @Resource
    private AtmService atmService;

    @Resource
    private AtmOptionService atmOptionService;

    @Resource
    private CityService cityService;

    @Resource
    private LocationService locationService;

    @Resource
    private OptionService optionService;

    @Resource
    private AtmMapper atmMapper;

    @Resource
    private CityMapper cityMapper;

    @Resource
    private LocationMapper locationMapper;

    @Resource
    private OptionMapper optionMapper;

    // See meetod on defineeritud nii, et ta ei võta väljapoolt sisse ühtegi parameetrit/andmeid/infot
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public List<CityDto> getAllCities() {

        // Kutsume välja meie poolt defineeritud meetodi cityService.findAll()
        // See meetod on meil ära defineeritud CityService klassis
        // cityService.findAll() on meil selliselt defineeritud, et ta ei võta väljapoolt sisse ühtegi parameetrit/andmeid/infot
        // Siin me ei anna väljakutsutavale meetodile kaasa mingeid sisendeid/infot
        // cityService.findAll() meetod on defineeritud nii, et see tagastab List<City> locations tüüpi objekti
        // Pane tähele, et hetkel me asume business kihi service sees ja siit klassis me ei pöördu otsae repository-de vastu,
        // vaid läheme läbi domain kihis asuva service
        // Ehk siis me lähme toome info ära
        //      MingiÄriController -> MingiÄriService -> MingiEntityService -> MingiEntityRepository ja saam kätte info kätte entiry objektidena
        // Kui 3 kihiline arhidektuuri teema on veel endiselt segane, siis palun vaata uuesti "GetMapping-Resource-Service-JSON" video.
        // NB! Seal videos veidi triviaalsem näide ja pole seda MingiEntityService osa.
        // https://youtu.be/2tB5ybhPGgk
        // vaata ka kommentaare selle 'cityService.findAll()' meetodi sees
        // Tulemus pannakse locations objekti sisse.
        List<City> allEntities = cityService.findAll();


        // (Entity -> Dto)
        // Siin vaatleme kõigepealt paremat poolt. Kutsutakse välja meetod citiesToCityDtos(), mis on defineeritud CityMapper klassis
        // citiesToCityDtos() on põhimõtteliselt mäpper meetod "Entity -> Dto"
        // citiesToCityDtos võtab parameetrina Entity (andmebaasi tabeli jaoks mõeldud klass) klassi tüüpi objekti
        // ja tagastab -> Dto (Data Transfer Object - andmete liigutamiseks mõeldud klass)
        // citiesToCityDtos() poolt tagastatud tulemus tagastatakse returniga
        // vaata ka kommentaare selle 'cityMapper.citiesToCityDtos()' meetodi sees
        List<CityDto> allDtos = cityMapper.citiesToCityDtos(allEntities);

        // RETURN'iga tagastatakse tulemus sinna kohta, kust see meetod välja kutsutakse
        return allDtos;
    }

    // See meetod on defineeritud nii, et ta võtab sisse Integer tüüpi objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod peab tagastama List<LocationDto> tüüpi objekti
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public List<LocationDto> getAtmLocationsByCityId(Integer cityId) {
        // Võtame getAtmLocationsByCityId() signatuuri parameetris sisse Integer tüüpi objekti
        // Siin signatuuris antakse sellele objekti muutujale nimeks 'cityId'

        // Kutsume välja meie poolt defineeritud meetodi locationService.findLocationsBy()
        // See meetod on meil ära defineeritud LocationService klassis
        // locationService.findLocationsBy() on meil selliselt defineeritud, et see võtab sisse parameetritena: Integer tüüpi objekti
        // Parameetrid on selleks vajalikud, et me saaksime meetodisse kaasa anda mingi objekti (andmed),
        // millega me soovime siis seal meetodi sees kuidagi toimetada.
        // Seega kuna meil on siin mingeid andmeid, mida mida väljakutsutav meetod vajab, siis me peame väljakutsumisel need kenasti kaasa andma.
        // locationService.findLocationsBy() meetod on defineeritud nii, et see tagastab List<Location> locations tüüpi objekti
        // Pane tähele, et hetkel me asume business kihi service sees ja siit klassis me ei pöördu otsae repository-de vastu,
        // vaid läheme läbi domain kihis asuva service
        // Ehk siis me lähme toome info ära
        //      MingiÄriController -> MingiÄriService -> MingiEntityService -> MingiEntityRepository ja saam kätte info kätte entiry objektidena
        // Kui 3 kihiline arhidektuuri teema on veel endiselt segane, siis palun vaata uuesti "GetMapping-Resource-Service-JSON" video.
        // NB! Seal videos veidi triviaalsem näide ja pole seda MingiEntityService osa.
        // https://youtu.be/2tB5ybhPGgk
        // vaata ka kommentaare selle 'locationService.findLocationsBy()' meetodi sees
        // Tulemus pannakse locations objekti sisse.
        List<Location> locations = locationService.findLocationsBy(cityId);

        // Siin kutstakse välja meetod mis asub siin selles samas klassis.
        // See selle klassi meetod on tehtud selleks, et saaksime panna mingi funktsionaalsuse elama konkreetsesse meetodisse.
        // Sellline lähenemine aitab parandada koodi loetavust ja võimaldab ka taaskasutust. Antud klassis on 2 korda seda meetodit välja kutsutud
        // Vaata ka kommentaare selle meetodi sees.
        List<LocationDto> locationDtos = createLocationDtos(locations);

        // RETURN'iga tagastatakse tulemus sinna kohta, kust see meetod välja kutsutakse
        return locationDtos;
    }

    public List<LocationDto> getAllAtmLocations() {
        List<Location> locations = locationService.findAll();
        List<LocationDto> locationDtos = createLocationDtos(locations);
        return locationDtos;
    }

    public List<OptionDto> getAllAtmOptions() {
        List<Option> entities = optionService.findAll();
        List<OptionDto> optionDtos = optionMapper.toDtos(entities);
        return optionDtos;

    }


    public void addAtm(AtmRequest request) {
        Atm atm = atmMapper.toEntity(request);
        Location location = locationService.findById(request.getLocationId());
        atm.setLocation(location);
        atmService.addAtm(atm);

        List<OptionDto> options = request.getOptions();
        for (OptionDto option : options) {
            if (option.getIsSelected()) {
                Integer optionId = option.getOptionId();
                Option optionEntity = optionService.findById(optionId);
                AtmOption atmOption = new AtmOption();
                atmOption.setAtm(atm);
                atmOption.setOption(optionEntity);
                atmOptionService.addAtmOption(atmOption);
            }
        }


        System.out.println();
    }

    // Siin kutstakse välja meetod mis asub siin selles samas klassis.
    // See selle klassi meetod on tehtud selleks, et saaksime panna mingi funktsionaalsuse elama konkreetsesse meetodisse.
    // Sellline lähenemine aitab parandada koodi loetavust ja võimaldab ka taaskasutust.
    // Seda meetodit on siin klassis välja kutsutud 2 korda.
    private List<LocationDto> createLocationDtos(List<Location> locations) {

        // (Entity -> Dto)
        // Siin vaatleme kõigepealt paremat poolt. Kutsutakse välja meetod toDtos(), mis on defineeritud LocationMapper klassis
        // toDtos() on põhimõtteliselt mäpper meetod "Entity -> Dto"
        // toDtos võtab parameetrina Entity (andmebaasi tabeli jaoks mõeldud klass) klassi tüüpi objekti
        // ja tagastab -> Dto (Data Transfer Object - andmete liigutamiseks mõeldud klass)
        // toDtos() poolt tagastatud tulemus tagastatakse returniga
        // vaata ka kommentaare selle 'locationMapper.toDtos()' meetodi sees
        List<LocationDto> locationDtos = locationMapper.toDtos(locations);

        // Siin kutstakse välja meetod mis asub siin selles samas klassis.
        // See selle klassi meetod on tehtud selleks, et saaksime panna mingi funktsionaalsuse elama konkreetsesse meetodisse.
        // Sellline lähenemine aitab parandada koodi loetavust ja võimaldab ka taaskasutust.
        // Vaata ka kommentaare selle meetodi sees.
        addAtmOptions(locationDtos);

        // RETURN'iga tagastatakse tulemus sinna kohta, kust see meetod välja kutsutakse
        return locationDtos;
    }

    // NB! See private meetod on defineeritud nii, et ta on nähtav vaid selle klassi meetoditele.
    // NB! Seda meetodit ei ole võimalik käivitada otse kuidagi väljaspoolt seda klassi
    // See meetod võtab sisse locationDtos tüüpi objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // Kuna addAtmOptions() meetod, on defineeritud nii, et see on 'void', siis siin meetodis midagi ei tagasta
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    private void addAtmOptions(List<LocationDto> locationDtos) {

        // Teeme for tsükkli kõikide asukohtade kohta ('locationDtos'), mis on Listis
        // Kui Listide for tsükli teema on veel endiselt segane, siis palun vaata uuesti "FOR tsükkel List":
        // https://youtu.be/aR5hP8dXvZ8
        // Käime kõik asukohad läbi ('locationDtos') ja lisame igal tsükklil ühe objekti 'dto' muutujasse
        for (LocationDto dto : locationDtos) {

            // Siin kutstakse välja meetod mis asub siin selles samas klassis.
            // See selle klassi meetod on tehtud selleks, et saaksime panna mingi funktsionaalsuse elama konkreetsesse meetodisse.
            // Sellline lähenemine aitab parandada koodi loetavust ja võimaldab ka taaskasutust.
            // Vaata ka kommentaare selle meetodi sees.
            addAtmOptionsToLocationDto(dto);
        }

        // NB! Siin meetodis ei saa olla RETURN statementi, kuna meetodi definitsiooni järgi ei tagasta see meetod midagi
    }

    // NB! See private meetod on defineeritud nii, et ta on nähtav vaid selle klassi meetoditele.
    // NB! Seda meetodit ei ole võimalik käivitada otse kuidagi väljaspoolt seda klassi
    // See meetod võtab sisse locationDtos tüüpi objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod peab tagastama List<LocationDto> tüüpi objekti
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    private void addAtmOptionsToLocationDto(LocationDto dto) {

        // Kutsume välja meie poolt defineeritud meetodi atmOptionService.findOptionsBy()
        // See meetod on meil ära defineeritud atmOptionService klassis
        // atmOptionService.findOptionsBy() on meil selliselt defineeritud, et see võtab sisse parameetritena: Integer tüüpi objekti
        // See on selleks vajalik, et me saaksime sellesse meetodisse kaasa anda mingi objekti (andmed),
        // millega me soovime siis seal meetodi sees kuidagi toimetada.
        // Seega kuna meil on siin mingid andmeid, mida mida väljakutsutav meetod vajab, siis me peame väljakutsumisel need kenasti kaasa andma.
        // atmOptionService.findOptionsBy() meetod on defineeritud nii, et see tagastab List<Option> options tüüpi objekti
        // Pane tähele, et hetkel me asume business kihi service sees ja siit klassis me ei pöördu otsae repository-de vastu,
        // vaid läheme läbi domain kihis asuva service
        // Ehk siis me lähme toome info ära
        //      MingiÄriController -> MingiÄriService -> MingiEntityService -> MingiEntityRepository ja saam kätte info kätte entiry objektidena
        // Kui 3 kihiline arhidektuuri teema on veel endiselt segane, siis palun vaata uuesti "GetMapping-Resource-Service-JSON" video.
        // NB! Seal videos veidi triviaalsem näide ja pole seda MingiEntityService osa.
        // https://youtu.be/2tB5ybhPGgk
        // vaata ka kommentaare selle 'atmOptionService.findOptionsBy()' meetodi sees
        // Tulemus pannakse options objekti sisse.
        List<Option> options = atmOptionService.findOptionsBy(dto.getLocationId());

        // (Entity -> Dto)
        // Siin vaatleme kõigepealt paremat poolt. Kutsutakse välja meetod toAtmOptionDtos(), mis on defineeritud OptionMapper klassis
        // toAtmOptionDtos() on põhimõtteliselt mäpper meetod "Entity -> Dto"
        // toAtmOptionDtos võtab parameetrina Listi Entity (andmebaasi tabeli jaoks mõeldud klass) klassi tüüpi objektidest
        // ja tagastab -> Listi Dto objektidest (Data Transfer Object - andmete liigutamiseks mõeldud klass)
        // toAtmOptionDtos() poolt tagastatud tulemus tagastatakse returniga
        // vaata ka kommentaare selle 'locationMapper.toAtmOptionDtos()' meetodi sees
        List<AtmOptionDto> atmOptionDtos = optionMapper.toAtmOptionDtos(options);

        // Setter meetodi abil siis väärtustatakse objekti väljasid.
        // Siin siis pannakse dto objekti väljale "options" külge varasemalt saadud tulemus
        // Kui getterite ja setterite teema on veel endiselt segane, siis palun vaata uuesti "Kasutaja poolt loodavad klassid":
        // https://youtu.be/2kZn9_03two
        dto.setOptions(atmOptionDtos);
    }

}
