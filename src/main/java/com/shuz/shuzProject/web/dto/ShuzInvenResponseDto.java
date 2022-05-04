package com.shuz.shuzProject.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@NoArgsConstructor
@Getter
@ToString
public class ShuzInvenResponseDto {
    private String storeName;
    private String storeLocation;
    private String storeNumber;
    private int invenQuantity;

    @Builder
    public ShuzInvenResponseDto(String storeName, String storeLocation, String storeNumber, int invenQuantity) {
        this.storeName = storeName;
        this.storeLocation = storeLocation;
        this.storeNumber = storeNumber;
        this.invenQuantity = invenQuantity;
    }

    public ShuzInvenResponseDto(Map<String, Object> stringObjectMap) {
    }
}
