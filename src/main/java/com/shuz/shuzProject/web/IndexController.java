package com.shuz.shuzProject.web;

import com.shuz.shuzProject.service.shuz.ShuzService;
import com.shuz.shuzProject.web.dto.ShuzListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final ShuzService shuzService;

    // 메인화면
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // 신발 전체
    @GetMapping("/shuz")
    public String shuz(Model model) {
        model.addAttribute("shuz", shuzService.findAllDesc());
        return "shuz";
    }

    // 신발 카테고리
    @GetMapping("/shuz/{shoes_type}")
    public String shuz(@PathVariable char shoes_type, Model model) {
        model.addAttribute("shuz", shuzService.findByShoesTypeAll(shoes_type));
        return"shuz";
    }

}


