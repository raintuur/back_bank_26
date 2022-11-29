package ee.valiit.back_bank_26.businesss.photo;

import ee.valiit.back_bank_26.domain.userrole.user.User;
import ee.valiit.back_bank_26.domain.userrole.user.UserMapper;
import ee.valiit.back_bank_26.domain.userrole.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PhotoService {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    public void addUserPhoto(PhotoDto request) {
        User user = userService.getValidUser(request.getUserId());
        userService.addUserPhoto(user, request.getPictureData());
    }
    public PhotoDto getUserPhoto(Integer userId) {
        User user = userService.getValidUser(userId);
        return userMapper.userToPhotoDto(user);
    }
}