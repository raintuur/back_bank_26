package ee.valiit.back_bank_26.photo;

import ee.valiit.back_bank_26.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @PostMapping()
    @Operation(summary = "Adds a photo to user")
    public void addUserPhoto(@RequestBody PhotoDto request) {
        photoService.addUserPhoto(request);
    }

    @GetMapping()
    @Operation(summary = "Finds user photo by userId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tagastab kasutaja pildi objekti, kus sees on kasutaja userId ja dataBase64 kodeeringus pildi String objekt"),
    })
    public PhotoDto getUserPhoto(Integer userId) {
        return photoService.getUserPhoto(userId);
    }

}
