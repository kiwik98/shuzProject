package com.shuz.shuzProject.web;

import com.shuz.shuzProject.service.inventory.InventoryService;
import com.shuz.shuzProject.service.shuz.ShuzService;
import com.shuz.shuzProject.web.dto.ShuzInvenRequestDto;
import com.shuz.shuzProject.web.dto.ShuzInvenResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ProductApiController {

    private final InventoryService inventoryService;

    @PostMapping("/api/invenSearch")
    @ResponseBody
    public void invenSearch(@RequestBody ShuzInvenRequestDto requestDto) {
        inventoryService.findInvenSearch(requestDto);
    }
}
