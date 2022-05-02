package com.shuz.shuzProject.service.inventory;

import com.shuz.shuzProject.domain.inventory.InventoryRepository;
import com.shuz.shuzProject.web.dto.ShuzInvenRequestDto;
import com.shuz.shuzProject.web.dto.ShuzInvenResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public void findInvenSearch(ShuzInvenRequestDto requestDto) {
        /*
        Inventory inventory = requestDto.toEntity();
        long no = inventory.getShoesNo();
        String size = inventory.getShoesSize();

        List<ShuzInvenResponseDto> dto = inventoryRepository.findInvenSearch(no, size).stream()
                .map(ShuzInvenResponseDto::new)
                .collect(Collectors.toList());

        System.out.println(dto);
*/
        Long no = requestDto.getShoesNo();
        String size = requestDto.getShoesSize();

//        inventoryRepository.findInvenSearch(no, size).stream()
//                .map(ShuzInvenResponseDto::new)
//                .collect(Collectors.toList());

        //inventoryRepository.findInvenSearch(no, size);

    }
}
