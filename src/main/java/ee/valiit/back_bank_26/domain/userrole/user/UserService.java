package ee.valiit.back_bank_26.domain.userrole.user;

import ee.valiit.back_bank_26.validation.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User getUserBy(String username, String password) {
        Optional<User> userOptional = userRepository.findBy(username, password);
        Validation.validateUserCredentials(userOptional);
        User user = userOptional.get();
        return user;
    }


    public User getUserBy(Integer userId) {
        return userRepository.findById(userId).get();
    }

    public void addUserPhoto(User user, String pictureData) {
        byte[] bytes = pictureData.getBytes(StandardCharsets.UTF_8);
        user.setPictureData(bytes);
        userRepository.save(user);
    }
}
