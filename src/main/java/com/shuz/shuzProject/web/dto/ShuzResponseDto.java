package com.shuz.shuzProject.web.dto;

import com.shuz.shuzProject.domain.shuz.Shuz;
import lombok.Getter;

@Getter
public class ShuzResponseDto {

    private Long shoes_no;
    private String shoes_name;
    private char shoes_sex;
    private char shoes_type;
    private String brand_type;
    private String shoes_price;
    private String shoes_img;

    public ShuzResponseDto(Shuz entity) {
        this.shoes_no = entity.getShoes_no();
        this.shoes_name = entity.getShoes_name();
        this.shoes_sex = entity.getShoes_sex();
        this.shoes_type = entity.getShoes_type();
        this.brand_type = entity.getBrand_type();
        this.shoes_price = entity.getShoes_price();
        this.shoes_img = entity.getShoes_img();
    }

    @Override
    public String toString() {
        return "ShuzResponseDto{" +
                "shoes_no=" + shoes_no +
                ", shoes_name='" + shoes_name + '\'' +
                ", shoes_sex=" + shoes_sex +
                ", shoes_type=" + shoes_type +
                ", brand_type=" + brand_type +
                ", shoes_price='" + shoes_price + '\'' +
                ", shoes_img='" + shoes_img + '\'' +
                '}';
    }
}
