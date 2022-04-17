package com.shuz.shuzProject.domain.shuz;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor

@Entity(name = "shoes")
public class Shuz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shoes_no;
    private String shoes_name;
    private char shoes_sex;
    private char shoes_type;
    private String brand_type;
    private String shoes_price;
    private String shoes_img;

    @Builder
    public Shuz(Long shoes_no, String shoes_name, char shoes_sex, char shoes_type, String brand_type, String shoes_price, String shoes_img) {
        this.shoes_no = shoes_no;
        this.shoes_name = shoes_name;
        this.shoes_sex = shoes_sex;
        this.shoes_type = shoes_type;
        this.brand_type = brand_type;
        this.shoes_price = shoes_price;
        this.shoes_img = shoes_img;
    }
}
