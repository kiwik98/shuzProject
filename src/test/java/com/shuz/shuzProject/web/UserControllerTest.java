package com.shuz.shuzProject.web;

import com.shuz.shuzProject.domain.user.User;
import com.shuz.shuzProject.service.user.UserService;
import com.shuz.shuzProject.web.UserController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserControllerTest {
    @Autowired
    private UserService userService;

    @DisplayName(value = "로그인 테스트")
    @Test
    public void loginTest() {
        User user = userService.findByUserId("1234");
        System.out.println(user.toString());
    }
}
