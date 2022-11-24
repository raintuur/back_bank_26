package ee.valiit.back_bank_26.login;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

@GetMapping("/login")
@Operation(summary = "Logib teenusesse sisse ja kontrollib username ja parooli")
    public LoginResponse login(@RequestParam String username, @RequestParam String password) {
       return loginService.login(username,password);
}
}
