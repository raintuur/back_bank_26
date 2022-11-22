package ee.valiit.back_bank_26.login;

import ee.valiit.back_bank_26.domain.userrole.user.User;
import ee.valiit.back_bank_26.domain.userrole.user.UserMapper;
import ee.valiit.back_bank_26.domain.userrole.user.UserRepository;
import ee.valiit.back_bank_26.domain.userrole.user.UserService;
import ee.valiit.back_bank_26.infrastructure.exception.BusinessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class LoginService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    public LoginResponse login(String username, String password) {
        User user = userService.getValidUser(username, password);
        LoginResponse loginResponse = userMapper.toLoginResponse(user);
        return loginResponse;
    }
}
