package com.shuz.shuzProject.service.wishlist;

import com.shuz.shuzProject.domain.wishlist.WishList;
import com.shuz.shuzProject.domain.wishlist.WishListRepository;
import com.shuz.shuzProject.web.dto.WishCheckResponseDto;
import com.shuz.shuzProject.web.dto.WishListRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class WishListService {

    private final WishListRepository wishListRepository;

    @Transactional
    public Long addWishList(WishListRequestDto dto) {

        Long no = wishListRepository.save(dto.toEntity()).getWishNo();
        System.out.println(no);
        return no;
        //wishListRepository.addWishList(userNo, shoesNo);
    }
    @Transactional
    public void deleteWishList(Long wishNo) {
        WishList wishList = wishListRepository.findById(wishNo).orElseThrow(() ->
                new IllegalArgumentException("해당 위시리스트가 없습니다. no=" + wishNo));
        wishListRepository.delete(wishList);
    }

    public WishCheckResponseDto wishCheck(Long userNo, Long shoesNo) {
//        WishList wishList = wishListRepository.findByUserNoAndShoesNo(userNo, shoesNo);
//        Long wishNo = wishList.getWishNo();
        WishCheckResponseDto wishCheckResponseDto = new WishCheckResponseDto();
        boolean check  = wishListRepository.existsByUserNoAndShoesNo(userNo, shoesNo);
        wishCheckResponseDto.setWishCheck(check);
        if(check) {
            WishList wishList = wishListRepository.findByUserNoAndShoesNo(userNo, shoesNo);
            Long wishNo = wishList.getWishNo();
            wishCheckResponseDto.setWishNo(wishNo);
        }
        return wishCheckResponseDto;
    }
}
