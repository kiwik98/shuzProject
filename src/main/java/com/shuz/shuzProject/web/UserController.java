package com.shuz.shuzProject.web;

import com.shuz.shuzProject.domain.user.User;
import com.shuz.shuzProject.service.user.UserService;
import com.shuz.shuzProject.web.dto.UserInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    //로그인 페이지
    @GetMapping("/login")
    public String loginForm() {

        return "login";
    }
    //로그인
    @PostMapping("/login")
    public String login(String id, String password, HttpSession session) {
        User user = userService.findByUserId(id);
        if(user == null) {
            System.out.println("로그인 실패!");
            return "redirect:/login";
        }
        if(!password.equals(user.getPassword())) {
            System.out.println("로그인 실패!");
            return "redirect:/login";
        }
        session.setAttribute("user", user);
        return "redirect:/";
    }

    //로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }

    //회원가입 페이지
    @GetMapping("/join")
    public String joinForm() {

        return "join";
    }

    //회원가입
    @PostMapping("/join")
    public String join(UserInfoDto userInfoDto) {
        userService.save(userInfoDto);
        return "redirect:/login";
    }
}
