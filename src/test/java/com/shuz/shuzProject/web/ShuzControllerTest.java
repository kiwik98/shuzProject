package com.shuz.shuzProject.web;

import com.shuz.shuzProject.service.shuz.ShuzService;
import com.shuz.shuzProject.web.dto.ShuzListResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import java.util.List;

@SpringBootTest
public class ShuzControllerTest {
    @Autowired
    private ShuzService shuzService;

    @DisplayName(value = "신발 검색 테스트")
    @Test
    public void searchTest() {
       // List<ShuzListResponseDto> list = shuzService.search("나이키");
        //List<ShuzListResponseDto> list2 = shuzService.search("니짜");
        //System.out.println("나이키 검색결과: " + list);
        //System.out.println("니짜 검색결과: " + list2);
    }
}
