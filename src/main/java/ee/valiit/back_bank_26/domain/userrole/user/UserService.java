package ee.valiit.back_bank_26.domain.userrole.user;

import ee.valiit.back_bank_26.infrastructure.exception.BusinessException;
import ee.valiit.back_bank_26.validation.BankError;
import ee.valiit.back_bank_26.validation.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public User getValidUser(String user, String password) {
        Optional<User> userOptional = userRepository.findBy(user, password);
        Validation.validateUserCredentials(userOptional);
        return userOptional.get();
    }


}
