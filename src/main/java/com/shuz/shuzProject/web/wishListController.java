package com.shuz.shuzProject.web;

import com.shuz.shuzProject.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class wishListController {

    @GetMapping("/wishList")
    public String wishList(HttpSession session) {
        //getSession 하고있엇음
        User user = (User)session.getAttribute("user");
        if(user==null){
            return"/login";
        }
        else
        return"wishList";
    }
}
