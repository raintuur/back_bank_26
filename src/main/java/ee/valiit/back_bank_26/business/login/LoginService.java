package ee.valiit.back_bank_26.business.login;

import ee.valiit.back_bank_26.domain.userrole.user.User;
import ee.valiit.back_bank_26.domain.userrole.user.UserMapper;
import ee.valiit.back_bank_26.domain.userrole.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
