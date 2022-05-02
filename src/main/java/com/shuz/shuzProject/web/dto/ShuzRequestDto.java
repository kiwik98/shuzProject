package com.shuz.shuzProject.web.dto;


import com.shuz.shuzProject.domain.shuz.Shuz;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShuzRequestDto {
    private Long shoesNo;
    private String shoesName;
    private char shoesSex;
    private char shoesType;
    private String brandType;
    private String shoesPrice;
    private String shoesImg;


    public Shuz toEntity() {
        return Shuz.builder()
                .shoesNo(shoesNo)
                .shoesName(shoesName)
                .shoesSex(shoesSex)
                .shoesType(shoesType)
                .brandType(brandType)
                .shoesPrice(shoesPrice)
                .shoesImg(shoesImg)
                .build();
    }

}
