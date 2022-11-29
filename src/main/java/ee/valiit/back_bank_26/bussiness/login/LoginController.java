package ee.valiit.back_bank_26.bussiness.login;

import ee.valiit.back_bank_26.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/login")
    @Operation(summary = "Logib teenusesse sisse ja kontrollib username ja parooli")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tagastab Objekti, kus sees on olemas userId, roleId ja roleType"),
            @ApiResponse(responseCode = "403", description = "Kasutajanimi või parool ei ühti andmebaasiga.",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public LoginResponse login(@RequestParam String username, @RequestParam String password) {
        return loginService.login(username, password);
    }
}
