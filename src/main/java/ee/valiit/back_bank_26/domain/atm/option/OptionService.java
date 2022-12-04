package ee.valiit.back_bank_26.domain.atm.option;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OptionService {

    @Resource
    private OptionRepository optionRepository;

    public List<Option> findAll() {
        List<Option> entities = optionRepository.findAll();
        return entities;
    }

    public Option findById(Integer optionId) {
        Option optionEntity = optionRepository.findById(optionId).get();
        return optionEntity;
    }
}
