package ee.valiit.back_bank_26.bussiness.login;

import ee.valiit.back_bank_26.domain.userrole.user.UserMapper;
import ee.valiit.back_bank_26.domain.userrole.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginService {
    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;

    public LoginResponse login(String user, String password) {
        return userMapper.toLoginResponse(userService.getUserBy(user, password));
    }
}
