package com.shuz.shuzProject.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class ShuzController {

    //남성화
    @GetMapping("/shuz/invenInfo")
    public String invenInfo() {
        return "invenInfo";
    }
}
