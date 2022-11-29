package ee.valiit.back_bank_26.domain.userrole.user;

import ee.valiit.back_bank_26.validation.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public User getUserBy(String userName, String password) {
        Optional<User> userOptional = userRepository.findBy(userName, password);
        Validation.validateUserCredentials(userOptional);
        return userOptional.get();
    }


    public User getUserBy(Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.get();
    }

    public void addUserPhoto(User user) {
        userRepository.save(user);
    }
}
