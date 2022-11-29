package ee.valiit.back_bank_26.businesss.photo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/photo", produces = MediaType.APPLICATION_JSON_VALUE)
public class PhotoController {

    @Resource
    private PhotoService photoService;

    @GetMapping()
    @Operation(summary = "Leiab kasutaja pildi tema userId jargi")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tagastab kasutaja pildi objekti, kus see on olemas kasutaja" +
                    "'userId' ja base64 kodeeringus pildi stringi 'pictureData'"),
    })
    public PhotoDto getUserPhoto(Integer userId) {
        return photoService.getUserPhoto(userId);
    }

    @PostMapping()
    @Operation(summary = "Lisab kasutaja pildi kasutades tema Id'd")
    public void addUserPhoto(@RequestBody PhotoDto request) {
        photoService.addUserPhoto(request);
    }
}
