package ee.valiit.back_bank_26.business.photo;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/photo")
public class PhotoController {

    @Resource
    private PhotoService photoService;

    @GetMapping()
    public PhotoDto getUserPhoto(Integer userId) {
        return photoService.getUserPhoto(userId);
    }

    @PostMapping()
    public void addUserPhoto(@RequestBody PhotoDto request) {
        photoService.addUserPhoto(request);
    }
}
