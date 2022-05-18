package com.shuz.shuzProject.domain.wishList;

import com.shuz.shuzProject.domain.wishlist.WishListRepository;
import com.shuz.shuzProject.web.dto.WishListRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
public class WishListRepositoryTest {
    @Autowired
    WishListRepository wishListRepository;

    @DisplayName(value = "레포지터리 테스트")
    @Transactional
    @Test
    public void repositoryTest() {
        WishListRequestDto dto = new WishListRequestDto();
        dto.setUserNo(2L);
        dto.setShoesNo(1L);

        Long wishNo = wishListRepository.save(dto.toEntity()).getWishNo();
        System.out.println(wishNo);
    }
}
