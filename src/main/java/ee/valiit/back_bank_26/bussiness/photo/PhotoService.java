package ee.valiit.back_bank_26.bussiness.photo;

import ee.valiit.back_bank_26.domain.userrole.user.User;
import ee.valiit.back_bank_26.domain.userrole.user.UserMapper;
import ee.valiit.back_bank_26.domain.userrole.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

@Service
public class PhotoService {
    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;

    public void addPhoto(PictureRequest request) {
        User user = userService.getUserBy(request.getUserId());
        user.setPicture_data(request.getPictureData().getBytes(StandardCharsets.UTF_8));
        userService.addUserPhoto(user);
    }

    public PhotoDto getPhoto(Integer userId) {
            return userMapper.userToPhotoDto(userService.getUserBy(userId));
    }
}
