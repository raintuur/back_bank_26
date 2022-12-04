package ee.valiit.back_bank_26.domain.atm;

import ee.valiit.back_bank_26.business.atm.dto.AtmRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AtmMapper {



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



    // Mäpper (Dto -> Entity)
    // Luuakse uut tüüpi objekt (mingist teisest klassist)
    // ja siis mäpitakse (kaardistatakse ja väärtustatakse) andmed uuele objektile ümber.

    // Siin on ära defineeritud meetod, millel ei ole keha
    // Projekti käivitamisel/jooksutamisel ehitatakse kogu projekt serverile kenasti valmis
    // ning selle ehitamise käigus üritab MapStructi tehnoloogia ise kirjutada valmis selle koodiosa,
    // millega tehakse üks uus objekt klassist Atm nii,
    // et kõik andmed võetakse siia meetodisse sisse tulevast 'request' objektist
    // Siin näites on nii, et mõlemas klassis on 2 samanimelist välja (serialNumber, status)
    // Need väljad mille nimed ja tüübid on täpselt samasugused, neid me ise kaardistama ei pea,
    // sest MapStruct oskab need kaardistused ise kokku viia
    // Kui MapStruct mäppimise teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine" ja "JPA Buddy mapperite kasutamine"
    // https://youtu.be/BrSMvqcGMio
    // https://youtu.be/AjGcVDcNlm4
    Atm toEntity(AtmRequest request);
}
