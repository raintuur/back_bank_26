package ee.valiit.back_bank_26.business.photo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/photo")
public class PhotoController {

    @Resource
    private PhotoService photoService;


    @PostMapping()
    public void addUserPhoto(@RequestBody PhotoRequest request) {
        photoService.addUserPhoto(request);
    }
}
