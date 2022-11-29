package ee.valiit.back_bank_26.bussiness.photo;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;

@Data
public class PictureRequest {

    private Integer userId;

    private String pictureData;
}
