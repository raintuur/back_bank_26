package ee.valiit.back_bank_26.atm;

import java.util.List;

public interface AtmMapper {

    //        todo: teeme entititest DTO'd
//              todo: vaja luua mapper
//                  todo: üksiku objekti mapper
//                      todo: mitme objekti (Listi) mappimine teiseks Listiks
//                            todo: tagastame mapitud listi (DTO'de list)

    AtmServiceInfo atmServiceToAtmServiceInfo(AtmService atmService);
    List<AtmServiceInfo> atmServicesToAtmServiceInfos(List<AtmService> atmServices);

}
