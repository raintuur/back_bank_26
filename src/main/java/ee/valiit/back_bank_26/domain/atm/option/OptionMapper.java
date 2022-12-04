package ee.valiit.back_bank_26.domain.atm.option;

import ee.valiit.back_bank_26.business.atm.dto.AtmOptionDto;
import org.mapstruct.*;

import java.util.List;

// See klass on interface
// See annotatsioon on siin all selle jaoks vajalik, et anda MapStruct tehnoloogiale märku,
// et siin klassis toimetatakse andmete üle tõstmisega  / kaaristamisega, ühe klassi objektilt, teise klassi objektile
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OptionMapper {


    @Mapping(source = "id", target = "optionId")
    @Mapping(source = "name", target = "optionName")
    @Mapping(constant = "false", target = "isSelected")
    OptionDto toDto(Option option);


    List<OptionDto> toDtos(List<Option> options);

    // Mäpper (Entity -> Dto)
    // Luuakse uut tüüpi objekt (mingist teisest klassist)
    // ja siis mäpitakse (kaardistatakse ja väärtustatakse) andmed uuele objektile ümber.

    // Siin näiteks kasutame @Mapping annotatsiooni, et aidata MapStructi mäpperi koodiosa kirjutamisel
    // source = meetodi signatuuri sees olev osa 'option' on sisend/sisse tulev info, millel on olemas väli 'id'
    // target = meetod tagastab AtmOptionDto tüüpi objekti (väljund), millel on väli 'optionId'
    // kaardistatakse mõlema objekti need väljad mis omavahel kokku käivad, ehk siis siin näites
    // 'option' objekti väljalt "id" soovime andmeid kanda üle tagastatavale AtmOptionDto tüüpi objekti 'optionId' väljale
    // Need väljad mille nimed ja tüübid on täpselt samasugused, neid me ise kaardistama ei pea,
    // sest MapStruct oskab need kaardistused ise kokku viia
    // Kui MapStruct mäppimise teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine" ja "JPA Buddy mapperite kasutamine"
    // https://youtu.be/BrSMvqcGMio
    // https://youtu.be/AjGcVDcNlm4
    @Mapping(source = "name", target = "optionName")
    AtmOptionDto toAtmOptionDto(Option option);

    // Mapping kaardistuse annotatsioone saab kasutada vaid üksik objektilt -> üksik objektile meetodis
    // Kui meil on näiteks vaja List<Entity> -> List<Dto> tüüpi kaardistust teha,
    // siis me kõigepealt teeme kaadistuse meetodis kaardistus üksik objektilt -> üksik objektile
    // ning siis loome juurde meetodi, mis võtab sisse ja tagastab samat tüüpi List'i
    // Sisuliselt MapStruct implementeerib selle lahenduse selliselt,
    // et "for loop'itakse" üksik objektilt -> üksik objektile meetodit
    List<AtmOptionDto> toAtmOptionDtos(List<Option> options);


}
