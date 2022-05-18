package com.shuz.shuzProject.web;

import com.shuz.shuzProject.domain.user.User;
import com.shuz.shuzProject.service.wishlist.WishListService;
import com.shuz.shuzProject.web.dto.WishListRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class wishListApiController {

    private final WishListService wishListService;

    //위시리스트 추가
    @PostMapping("/api/wishList")
    @ResponseBody
    public Long addWishList(@RequestBody Long shoesNo, HttpSession session) {
        User user = (User)session.getAttribute("user");
        Long userNo = user.getUserNo();
        WishListRequestDto dto = new WishListRequestDto();
        dto.setUserNo(userNo);
        dto.setShoesNo(shoesNo);
        return wishListService.addWishList(dto);
    }

    @DeleteMapping("/api/wishList/{wishNo}")
    @ResponseBody
    public Long deleteWishList(@PathVariable Long wishNo) {
        wishListService.deleteWishList(wishNo);
        return wishNo;
    }
}
