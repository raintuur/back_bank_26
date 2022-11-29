package ee.valiit.back_bank_26.business.photo;

import ee.valiit.back_bank_26.domain.userrole.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PhotoService {

    @Resource
    private UserService userService;


    public void addUserPhoto(PhotoRequest request) {
        userService.getUserBy(request.getUserId());
    }
}
