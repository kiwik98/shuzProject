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
}
