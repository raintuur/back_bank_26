package ee.valiit.back_bank_26.login;

import ee.valiit.back_bank_26.domain.userrole.user.LoginResponse;
import ee.valiit.back_bank_26.domain.userrole.user.User;
import ee.valiit.back_bank_26.domain.userrole.user.UserMapper;
import ee.valiit.back_bank_26.domain.userrole.user.UserRepository;
import ee.valiit.back_bank_26.infrastructure.exception.BusinessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class LoginService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRepository userRepository;

    public LoginResponse login(String username, String password) {
        Optional<User> userOptional = userRepository.findBy(username, password);
        // kui ei leia siis viska viga
        if (userOptional.isEmpty()) {
            throw new BusinessException("Oled loll", "666");
        }
        User user = userOptional.get();
        LoginResponse loginResponse = userMapper.toLoginResponse(user);
        return loginResponse;
    }
}
