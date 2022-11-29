package ee.valiit.back_bank_26.bussiness.photo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/photo")
public class PhotoController {

    @Resource
    private PhotoService photoService;

    @GetMapping("")
    @Operation(summary = "Leiab kasutaja pildid tema userId järgi")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description =
                    "Tagastab kasutaja pildi objekti, kus sees on olemas kasutaja 'userId' ja " +
                            "base64 kodeeringus pildi strin 'pictureData'")
    })
    public PhotoDto getPhoto(@RequestParam Integer userId) {
        return photoService.getPhoto(userId);
    }

    @PostMapping("")
    @Operation(summary = "Leiab userId järgi andmebaasist kasutajale pildi. " +
            "Pilt tuleb sisse request objektis String base64 kodeeringus. " +
            "Teenus mappib Stringi ümber byte[] ja salvestab andmebaasi")

    public void addPhoto(@RequestBody PictureRequest request) {
        photoService.addPhoto(request);
    }
}
