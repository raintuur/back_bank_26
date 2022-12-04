package ee.valiit.back_bank_26.domain.city;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CityService {

    @Resource
    private CityRepository cityRepository;

    public List<City> findAll() {
        List<City> allEntities = cityRepository.findAll();
        return allEntities;
    }
}
