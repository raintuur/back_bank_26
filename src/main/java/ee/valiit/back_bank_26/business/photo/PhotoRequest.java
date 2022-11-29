package ee.valiit.back_bank_26.business.photo;

import lombok.Data;

@Data
public class PhotoRequest {
    private Integer userId;
    private String pictureData;
}
