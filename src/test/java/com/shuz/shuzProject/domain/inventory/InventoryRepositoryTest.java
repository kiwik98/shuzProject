package com.shuz.shuzProject.domain.inventory;

import com.shuz.shuzProject.domain.shuz.Shuz;
import com.shuz.shuzProject.domain.store.Store;
import com.shuz.shuzProject.web.dto.ShuzInvenResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InventoryRepositoryTest {
    @Autowired
    private InventoryRepository inventoryRepository;

    @DisplayName(value = "레포지터리 테스트")
    @Transactional
    @Test
    public void repositoryTest(){
        List<ShuzInvenResponseDto> shuzInvenResponseDtos = new ArrayList<>();
        List<Map<String, Object>> test = inventoryRepository.findInvenSearch(2L, "270");

        for(Map<String,Object> map : test){
            ShuzInvenResponseDto shuzInvenResponseDto = ShuzInvenResponseDto.builder()
                    .invenNo((Long) map.get("invenNo"))
                    .storeNumber((String) map.get("storeNumber"))
                    .storeName((String) map.get("storeName"))
                    .storeLocation((String) map.get("storeLocation"))
                    .invenQuantity((Integer) map.get("invenQuantity"))
                    .build();
            shuzInvenResponseDtos.add(shuzInvenResponseDto);
        }

        System.out.printf("----------------------------------------------------------------------\n");
        for(ShuzInvenResponseDto shuzInvenResponseDto : shuzInvenResponseDtos){
            System.out.printf("재고번호 : " + shuzInvenResponseDto.getInvenNo() + "\n");
            System.out.printf("상점이름 : " + shuzInvenResponseDto.getStoreName() + "\n");
            System.out.printf("상점번호 : " + shuzInvenResponseDto.getStoreNumber() + "\n");
            System.out.printf("상점위치 : " + shuzInvenResponseDto.getStoreLocation() + "\n");
            System.out.printf("재고수량 : " + String.valueOf(shuzInvenResponseDto.getInvenQuantity()) + "\n");
        }
        System.out.printf("----------------------------------------------------------------------\n");
//        Inventory inventory = inventoryRepository.findById(1l).orElseThrow(RuntimeException::new);
    }
    @DisplayName(value = "재고수량 수정 테스트")
    @Transactional
    @Test
    public void invenQuantityTest() {
        inventoryRepository.updateQuantity(10, 1L);
        System.out.printf("test");
    }
}