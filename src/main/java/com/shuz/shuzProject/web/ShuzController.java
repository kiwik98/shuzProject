package com.shuz.shuzProject.web;

import com.shuz.shuzProject.service.shuz.ShuzService;
import com.shuz.shuzProject.web.dto.ShuzListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ShuzController {

    private final ShuzService shuzService;

    /* 메인메뉴 */
    // 젠더별 신발 전체 리스트
    @GetMapping("/shuz/{shoesSex}/all")
    public String findByShoesSexAll(@PathVariable char shoesSex, Model model) {

        List<ShuzListResponseDto> list = shuzService.findByShoesSexAll(shoesSex);
        model.addAttribute("shuz", list);
        model.addAttribute("head", "ALL");
        return "shuz";
    }

    // 신발 종류 카테고리 리스트
    @GetMapping("/shuz/{shoesSex}/{shoesType}")
    public String findByShoesTypeAll(@PathVariable char shoesSex, @PathVariable char shoesType, Model model) {
        String type = shoesType(shoesType);
        List<ShuzListResponseDto> list = shuzService.findByShoesTypeAll(shoesSex, shoesType);
        model.addAttribute("shuz", list);
        model.addAttribute("head", type);
        return"shuz";
    }
    /* 메인메뉴 */

    /* 서브메뉴 */
    //ALL 브랜드 별 메뉴
    @GetMapping("/shuz/{shoesSex}/all/{brandType}")
    public String findByBrandTypeAll(@PathVariable char shoesSex, @PathVariable String brandType, Model model) {
        List<ShuzListResponseDto> list = shuzService.findByBrandTypeAll(shoesSex, brandType);
        model.addAttribute("shuz", list);
        model.addAttribute("head", "ALL");
        return "shuz";
    }
    //신발 종류 브랜드 별 메뉴
    @GetMapping("/shuz/{shoesSex}/{shoesType}/{brandType}")
    public String findByBrandTypeAll(@PathVariable char shoesSex, @PathVariable char shoesType,
                                     @PathVariable String brandType, Model model) {

        String type = shoesType(shoesType);
        List<ShuzListResponseDto> list = shuzService.findByBrandTypeOne(shoesSex, shoesType, brandType);
        model.addAttribute("shuz", list);
        model.addAttribute("head", type);
        return "shuz";
    }
    /* 서브메뉴 */

    // 신발 종류 코드 -> 문자열로 변환 함수
    public static String shoesType(char shoesType) {
        String type = "";
        switch (shoesType) { // 머스테치 if문 x 컨트롤러에서 최종값 보내주기
            case '0':
                type = "스니커즈";
                break;
            case '1':
                type = "스포츠";
                break;
            case '2':
                type = "캔버스";
                break;
        }
        return type;

    }
}