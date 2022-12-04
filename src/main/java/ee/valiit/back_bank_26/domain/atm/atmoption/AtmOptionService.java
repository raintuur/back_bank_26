package ee.valiit.back_bank_26.domain.atm.atmoption;

import ee.valiit.back_bank_26.domain.atm.option.Option;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AtmOptionService {

    @Resource
    private AtmOptionRepository atmOptionRepository;

    public List<Option> findOptionsBy(Integer locationId) {
        List<Option> options = atmOptionRepository.findOptionsBy(locationId);
        return options;
    }

    public void addAtmOption(AtmOption atmOption) {
        atmOptionRepository.save(atmOption);
    }
}
