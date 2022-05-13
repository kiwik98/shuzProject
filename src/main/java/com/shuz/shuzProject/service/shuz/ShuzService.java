package com.shuz.shuzProject.service.shuz;

import com.shuz.shuzProject.domain.shuz.Shuz;
import com.shuz.shuzProject.domain.shuz.ShuzRepository;
import com.shuz.shuzProject.web.dto.ShuzListResponseDto;
import com.shuz.shuzProject.web.dto.ShuzResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ShuzService {

    private final ShuzRepository shuzRepository;

    /* 메인메뉴 */
    // 젠더별 신발 전체 리스트
    public List<ShuzListResponseDto> findByShoesSexAll(char shoesSex, Pageable pageable) {// 신발 종류 카테고리 리스트
        return shuzRepository.findByShoesSex(shoesSex, pageable).stream()
                .map(ShuzListResponseDto::new)
                .collect(Collectors.toList());
    }
    // 신발 종류 카테고리 리스트
    public List<ShuzListResponseDto> findByShoesTypeAll(char shoesSex, char shoesType, Pageable pageable) {// 신발 종류 카테고리 리스트
        return shuzRepository.findByShoesSexAndShoesType(shoesSex, shoesType, pageable).stream()
                .map(ShuzListResponseDto::new)
                .collect(Collectors.toList());
    }
    /* 메인메뉴 */

    /* 서브메뉴 */
    //ALL 브랜드 별 메뉴
    public List<ShuzListResponseDto> findByBrandTypeAll(char shoesSex, String brandType, Pageable pageable) {
        return shuzRepository.findByShoesSexAndBrandType(shoesSex, brandType, pageable).stream()
                .map(ShuzListResponseDto::new)
                .collect(Collectors.toList());
    }
    //신발 종류 브랜드 별 메뉴
    public List<ShuzListResponseDto> findByBrandTypeOne(char shoesSex, char shoesType, String brandType, Pageable pageable) {
        return shuzRepository.findByShoesSexAndShoesTypeAndBrandType(shoesSex, shoesType, brandType, pageable).stream()
                .map(ShuzListResponseDto::new)
                .collect(Collectors.toList());
    }
    /* 서브메뉴 */

    //신발 검색
    public List<ShuzListResponseDto> search(String keyword, Pageable pageable) {
        return shuzRepository.findByShoesNameContaining(keyword, pageable).stream()
                .map(ShuzListResponseDto::new)
                .collect(Collectors.toList());
    }

    /* 상세페이지 */
    public ShuzResponseDto findByProductInfoOne(long shoesNo){

        Shuz entity = shuzRepository.findById(shoesNo).orElseThrow(() ->
                new IllegalArgumentException("해당 상품이 없습니다. id="+ shoesNo));

        return new ShuzResponseDto(entity);

    }

}
