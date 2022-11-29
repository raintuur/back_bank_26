package ee.valiit.back_bank_26.business.photo;

import ee.valiit.back_bank_26.domain.userrole.user.User;
import ee.valiit.back_bank_26.domain.userrole.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

@Service
public class PhotoService {

    @Resource
    private UserService userService;


    public void addUserPhoto(PhotoRequest request) {
        User user = userService.getUserBy(request.getUserId());
        addUserPhoto(user, request.getPictureData());


    }

    private static void addUserPhoto(User user, String pictureData) {
        byte[] pictureAsByteArray = pictureData.getBytes(StandardCharsets.UTF_8);
        user.setPictureData(pictureAsByteArray);
    }
}
