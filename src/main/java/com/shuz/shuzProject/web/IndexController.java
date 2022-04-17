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

    // 젠더별 신발 전체 리스트
    @GetMapping("/shuz/{shoes_sex}")
    public String findByShoesSexAll(@PathVariable char shoes_sex, Model model) {
        model.addAttribute("shuz", shuzService.findByShoesSexAll(shoes_sex));
        return "shuz";
    }

    // 신발 종류 카테고리 리스트
    @GetMapping("/shuz/{shoes_sex}/{shoes_type}")
    public String findByShoesTypeAll(@PathVariable char shoes_sex, @PathVariable char shoes_type, Model model) {
        model.addAttribute("shuz", shuzService.findByShoesTypeAll(shoes_sex, shoes_type));
        return"shuz";
    }

}


