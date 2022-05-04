package com.shuz.shuzProject.service.inventory;

import com.shuz.shuzProject.domain.inventory.InventoryRepository;
import com.shuz.shuzProject.web.dto.ShuzInvenRequestDto;
import com.shuz.shuzProject.web.dto.ShuzInvenResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public List<ShuzInvenResponseDto> findInvenSearch(ShuzInvenRequestDto requestDto) {

        Long no = requestDto.getShoesNo();
        String size = requestDto.getShoesSize();

        List<ShuzInvenResponseDto> shuzInvenResponseDtos = new ArrayList<>();
        List<Map<String, Object>> list = inventoryRepository.findInvenSearch(no, size);

        for(Map<String,Object> map : list){
            ShuzInvenResponseDto shuzInvenResponseDto = ShuzInvenResponseDto.builder()
                    .storeNumber((String) map.get("storeNumber"))
                    .storeName((String) map.get("storeName"))
                    .storeLocation((String) map.get("storeLocation"))
                    .invenQuantity((Integer) map.get("invenQuantity"))
                    .build();
            shuzInvenResponseDtos.add(shuzInvenResponseDto);
        }

        return shuzInvenResponseDtos;

//        inventoryRepository.findInvenSearch(no, size).stream()
//                .map(ShuzInvenResponseDto::new)
//                .collect(Collectors.toList());

        //inventoryRepository.findInvenSearch(no, size);

    }
}
