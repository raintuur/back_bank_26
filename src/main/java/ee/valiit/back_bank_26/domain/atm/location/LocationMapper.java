package ee.valiit.back_bank_26.domain.atm.location;

import org.mapstruct.*;

import java.util.List;

// See klass on interface
// See annotatsioon on siin all selle jaoks vajalik, et anda MapStruct tehnoloogiale märku,
// et siin klassis toimetatakse andmete üle tõstmisega  / kaaristamisega, ühe klassi objektilt, teise klassi objektile
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LocationMapper {

    // Mäpper (Entity -> Dto)
    // Luuakse uut tüüpi objekt (mingist teisest klassist)
    // ja siis mäpitakse (kaardistatakse ja väärtustatakse) andmed uuele objektile ümber.

    // Siin on ära defineeritud meetod, millel ei ole keha
    // Projekti käivitamisel/jooksutamisel ehitatakse kogu projekt serverile kenasti valmis
    // ning selle ehitamise käigus üritab MapStructi tehnoloogia ise kirjutada valmis selle koodiosa,
    // millega tehakse üks uus objekt klassist LocationDto nii,
    // et kõik andmed võetakse siia meetodisse sisse tulevast 'location' objektist

    // Siin näiteks kasutame @Mapping annotatsiooni, et aidata MapStructi mäpperi koodiosa kirjutamisel
    // source = meetodi signatuuri sees olev osa 'location' on sisend/sisse tulev info, millel on olemas väli 'id'
    // target = meetod tagastab LocationDto tüüpi objekti (väljund), millel on väli 'locationId'
    // kaardistatakse mõlema objekti need väljad mis omavahel kokku käivad, ehk siis siin näites
    // 'location' objekti väljalt "id" soovime andmeid kanda üle tagastatavale LocationDto tüüpi objekti 'locationId' väljale
    // Need väljad mille nimed ja tüübid on täpselt samasugused, neid me ise kaardistama ei pea,
    // sest MapStruct oskab need kaardistused ise kokku viia
    // Kui MapStruct mäppimise teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine" ja "JPA Buddy mapperite kasutamine"
    // https://youtu.be/BrSMvqcGMio
    // https://youtu.be/AjGcVDcNlm4
    @Mapping(source = "id", target = "locationId")
    @Mapping(source = "name", target = "locationName")
    @Mapping(source = "city.name", target = "cityName")
    LocationDto toDto(Location location);

    // Mapping kaardistuse annotatsioone saab kasutada vaid üksik objektilt -> üksik objektile meetodis
    // Kui meil on näiteks vaja List<Entity> -> List<Dto> tüüpi kaardistust teha,
    // siis me kõigepealt teeme kaadistuse meetodis kaardistus üksik objektilt -> üksik objektile
    // ning siis loome juurde meetodi, mis võtab sisse ja tagastab samat tüüpi List'i
    // Sisuliselt MapStruct implementeerib selle lahenduse selliselt,
    // et "for loop'itakse" üksik objektilt -> üksik objektile meetodit
    List<LocationDto> toDtos(List<Location> locations);

}
