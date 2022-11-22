package ee.valiit.back_bank_26.login;

import ee.valiit.back_bank_26.domain.userrole.user.User;
import ee.valiit.back_bank_26.domain.userrole.user.UserRepository;
import ee.valiit.back_bank_26.infrastructure.exception.BusinessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class LoginService {

    @Resource
    private UserRepository userRepository;

    public void login(String username, String password) {
        Optional<User> userOptional = userRepository.findBy(username, password);

        // kui ei leia siis viska viga
        if (userOptional.isEmpty()) {
            throw new BusinessException("Oled loll", "666");
        }


    }
}
