package com.shuz.shuzProject.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class WishListResponseDto {
    private Long shoesNo;
    private String shoesName;
    private String brandType;
    private String shoesPrice;
    private String shoesImg;
    private Long wishNo;

    @Builder
    public WishListResponseDto(Long shoesNo, String shoesName, String brandType, String shoesPrice, String shoesImg, Long wishNo) {
        this.shoesNo = shoesNo;
        this.shoesName = shoesName;
        this.brandType = brandType;
        this.shoesPrice = shoesPrice;
        this.shoesImg = shoesImg;
        this.wishNo = wishNo;
    }


}

