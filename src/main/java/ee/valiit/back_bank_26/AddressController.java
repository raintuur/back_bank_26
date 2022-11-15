package ee.valiit.back_bank_26;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AddressController {


    @GetMapping("/atm/city")
    public List<CityInfo> getCitiesInfo() {
        List<CityInfo> cityInfo = createCityInfos();
        return cityInfo;
    }

    private static List<CityInfo> createCityInfos() {
        List<CityInfo> cityInfoList = new ArrayList<>();

        CityInfo cityInfo1 = new CityInfo();
        cityInfo1.setCityName("Tallinn");
        cityInfo1.setCityNameId(1);

        CityInfo cityInfo2 = new CityInfo();
        cityInfo2.setCityName("Tartu");
        cityInfo2.setCityNameId(2);

        CityInfo cityInfo3 = new CityInfo();
        cityInfo3.setCityName("Pärnu");
        cityInfo3.setCityNameId(3);
        System.out.println();

        cityInfoList.add(cityInfo1);
        cityInfoList.add(cityInfo2);
        cityInfoList.add(cityInfo3);
        return cityInfoList;
    }

}
