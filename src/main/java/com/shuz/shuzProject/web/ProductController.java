package com.shuz.shuzProject.web;

import com.shuz.shuzProject.service.shuz.ShuzService;
import com.shuz.shuzProject.web.dto.ShuzResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ShuzService shuzService;

    /* 상세페이지 */
    @GetMapping("/product/{shoes_no}")
    public String findByProductInfoOne(@PathVariable long shoes_no, Model model) {

        ShuzResponseDto productInfo = shuzService.findByProductInfoOne(shoes_no);
        String type = ShuzController.shoesType(productInfo.getShoes_type());

        model.addAttribute("shuz", productInfo);
        model.addAttribute("head", type);

        return "productInfo";
    }

    /* 상세페이지 */
}
