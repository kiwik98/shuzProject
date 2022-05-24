package com.shuz.shuzProject.domain.shuz;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor

@Entity
@Table(name ="shoes")
public class Shuz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shoesNo;
    private String shoesName;
    private char shoesSex;
    private char shoesType;
    private String brandType;
    private String shoesPrice;
    private String shoesImg;

    @Builder
    public Shuz(Long shoesNo, String shoesName, char shoesSex, char shoesType, String brandType, String shoesPrice, String shoesImg) {
        this.shoesNo = shoesNo;
        this.shoesName = shoesName;
        this.shoesSex = shoesSex;
        this.shoesType = shoesType;
        this.brandType = brandType;
        this.shoesPrice = shoesPrice;
        this.shoesImg = shoesImg;
    }
    // 신발 종류 코드 -> 문자열로 변환 함수
    public static String getBrandName(char shoesType) {
        String type = "";
        switch (shoesType) { // 머스테치 if문 x 컨트롤러에서 최종값 보내주기
            case '0':
                type = "스니커즈";
                break;
            case '1':
                type = "스포츠";
                break;
            case '2':
                type = "캔버스";
                break;
        }
        return type;
    }
}
