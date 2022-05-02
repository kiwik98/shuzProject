package com.shuz.shuzProject.web.dto;

import com.shuz.shuzProject.domain.shuz.Shuz;
import lombok.Getter;

@Getter
public class ShuzListResponseDto {
    private Long shoesNo;
    private String shoesName;
    private char shoesSex;
    private char shoesType;
    private String brandType;
    private String shoesPrice;
    private String shoesImg;

    public ShuzListResponseDto(Shuz entity) {
        this.shoesNo = entity.getShoesNo();
        this.shoesName = entity.getShoesName();
        this.shoesSex = entity.getShoesSex();
        this.shoesType = entity.getShoesType();
        this.brandType = entity.getBrandType();
        this.shoesPrice = entity.getShoesPrice();
        this.shoesImg = entity.getShoesImg();
    }
}
