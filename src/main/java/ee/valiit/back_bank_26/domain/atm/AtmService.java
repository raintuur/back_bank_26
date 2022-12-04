package ee.valiit.back_bank_26.domain.atm;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AtmService {
    @Resource
    private AtmRepository atmRepository;

    public void addAtm(Atm atm) {
        atmRepository.save(atm);
    }
}
