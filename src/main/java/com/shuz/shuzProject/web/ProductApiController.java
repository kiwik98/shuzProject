package com.shuz.shuzProject.web;

import com.shuz.shuzProject.service.inventory.InventoryService;
import com.shuz.shuzProject.service.shuz.ShuzService;
import com.shuz.shuzProject.web.dto.ShuzInvenRequestDto;
import com.shuz.shuzProject.web.dto.ShuzInvenResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ProductApiController {

    private final InventoryService inventoryService;

    //재고 조회 API
    @PostMapping("/api/invenSearch")
    @ResponseBody
    public List<ShuzInvenResponseDto> invenSearch(@RequestBody ShuzInvenRequestDto requestDto) {

        return inventoryService.findInvenSearch(requestDto);
    }

    //재고 수정 API
    @PutMapping("/api/invenQuantity/{invenNo}")
    @ResponseBody
    public int invenQuantity(@PathVariable Long invenNo, @RequestBody int invenQuantity) {
        inventoryService.updateQuantity(invenQuantity, invenNo);

        return invenQuantity;
    }
}
