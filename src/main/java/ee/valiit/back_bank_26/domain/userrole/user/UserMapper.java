package ee.valiit.back_bank_26.domain.userrole.user;

import ee.valiit.back_bank_26.login.LoginResponse;
import ee.valiit.back_bank_26.photo.PhotoDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.id", target = "roleId")
    @Mapping(source = "role.type", target = "roleType")
    LoginResponse toLoginResponse(User user);

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "pictureData", target = "pictureData", qualifiedByName = "byteArrayToString")
    PhotoDto userToPhotoDto(User user);

    @Named("byteArrayToString")
    static String byteArrayToString(byte[] pictureData) {
        if (pictureData == null) {
            return null;
        }
        return new String(pictureData);
    }
}
