package com.shuz.shuzProject.web.dto;

import com.shuz.shuzProject.domain.inventory.Inventory;
import com.shuz.shuzProject.domain.shuz.Shuz;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShuzInvenRequestDto {

    private Long shoesNo;
    private String shoesSize;
    /*
    public Inventory toEntity() {
        return Inventory.builder()
                .shoesNo(shoesNo)
                .shoesSize(shoesSize)
                .build();
    }
    */
}
