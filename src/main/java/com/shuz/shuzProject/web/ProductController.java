package com.shuz.shuzProject.web;

import com.shuz.shuzProject.domain.user.User;
import com.shuz.shuzProject.service.shuz.ShuzService;
import com.shuz.shuzProject.service.wishlist.WishListService;
import com.shuz.shuzProject.web.dto.ShuzResponseDto;
import com.shuz.shuzProject.web.dto.WishCheckResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ShuzService shuzService;
    private final WishListService wishListService;

    /* 상세페이지 */
    @GetMapping("/product/{shoesNo}")
    public String findByProductInfoOne(@PathVariable long shoesNo, Model model, HttpSession session) {

        ShuzResponseDto productInfo = shuzService.findByProductInfoOne(shoesNo);
        String type = ShuzController.shoesType(productInfo.getShoesType());

        model.addAttribute("shuz", productInfo);
        model.addAttribute("head", type);
        User user = (User) session.getAttribute("user");
        if(user != null){
            Long userNo = user.getUserNo();
            WishCheckResponseDto wishCheckResponseDto = wishListService.wishCheck(userNo, shoesNo);
            model.addAttribute("wishCheckDto", wishCheckResponseDto);
        }

        return "productInfo";
    }

    /* 상세페이지 */
}
