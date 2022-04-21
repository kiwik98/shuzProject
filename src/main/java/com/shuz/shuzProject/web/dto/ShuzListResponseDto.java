package com.shuz.shuzProject.web.dto;

import com.shuz.shuzProject.domain.shuz.Shuz;
import lombok.Getter;

@Getter
public class ShuzListResponseDto {
    private Long shoes_no;
    private String shoes_name;
    private char shoes_sex;
    private char shoes_type;
    private String brand_type;
    private String shoes_price;
    private String shoes_img;

    public ShuzListResponseDto(Shuz entity) {
        this.shoes_no = entity.getShoes_no();
        this.shoes_name = entity.getShoes_name();
        this.shoes_sex = entity.getShoes_sex();
        this.shoes_type = entity.getShoes_type();
        this.brand_type = entity.getBrand_type();
        this.shoes_price = entity.getShoes_price();
        this.shoes_img = entity.getShoes_img();
    }
}
