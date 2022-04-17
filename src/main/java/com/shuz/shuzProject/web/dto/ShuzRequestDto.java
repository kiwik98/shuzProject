package com.shuz.shuzProject.web.dto;


import com.shuz.shuzProject.domain.shuz.Shuz;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShuzRequestDto {
    private Long shoes_no;
    private String shoes_name;
    private char shoes_sex;
    private char shoes_type;
    private String brand_type;
    private String shoes_price;
    private String shoes_img;


    public Shuz toEntity() {
        return Shuz.builder()
                .shoes_no(shoes_no)
                .shoes_name(shoes_name)
                .shoes_sex(shoes_sex)
                .shoes_type(shoes_type)
                .brand_type(brand_type)
                .shoes_price(shoes_price)
                .shoes_img(shoes_img)
                .build();
    }

}
