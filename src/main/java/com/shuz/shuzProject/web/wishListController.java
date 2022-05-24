package com.shuz.shuzProject.web;

import com.shuz.shuzProject.domain.user.User;
import com.shuz.shuzProject.service.shuz.ShuzService;
import com.shuz.shuzProject.web.dto.WishListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class wishListController {

    private final ShuzService shuzService;

    @GetMapping("/wishList")
    public String wishList(HttpSession session, Model model) {
        User user = (User)session.getAttribute("user");
        if(user==null){
            return"/login";
        }
        else {
            Long userNo = user.getUserNo();
            List<WishListResponseDto> list = shuzService.getWishList(userNo);
            int count = shuzService.getWishCount(userNo);
            model.addAttribute("wishList", list);
            model.addAttribute("count", count);
            return "wishList";
        }
    }
}
