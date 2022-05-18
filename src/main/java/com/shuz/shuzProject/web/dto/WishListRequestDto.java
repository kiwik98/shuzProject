package com.shuz.shuzProject.web.dto;

import com.shuz.shuzProject.domain.wishlist.WishList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WishListRequestDto {
    private Long userNo;
    private Long shoesNo;

    public WishList toEntity() {
        return WishList.builder()
                .userNo(userNo)
                .shoesNo(shoesNo)
                .build();
    }
}
