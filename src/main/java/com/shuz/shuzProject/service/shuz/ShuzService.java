package com.shuz.shuzProject.service.shuz;

import com.shuz.shuzProject.domain.shuz.Shuz;
import com.shuz.shuzProject.domain.shuz.ShuzRepository;
import com.shuz.shuzProject.web.dto.ShuzListResponseDto;
import lombok.RequiredArgsConstructor;
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
    public List<ShuzListResponseDto> findByShoesSexAll(char shoes_sex) {// 신발 종류 카테고리 리스트
        return shuzRepository.findByShoesSexAll(shoes_sex).stream()
                .map(ShuzListResponseDto::new)
                .collect(Collectors.toList());
    }
    // 신발 종류 카테고리 리스트
    public List<ShuzListResponseDto> findByShoesTypeAll(char shoes_sex, char shoes_type) {// 신발 종류 카테고리 리스트
        return shuzRepository.findByShoesTypeAll(shoes_sex, shoes_type).stream()
                .map(ShuzListResponseDto::new)
                .collect(Collectors.toList());
    }
    /* 메인메뉴 */

    /* 서브메뉴 */
    //ALL 브랜드 별 메뉴
    public List<ShuzListResponseDto> findByBrandTypeAll(char shoes_sex, String brand_type) {
        return shuzRepository.findByBrandTypeAll(shoes_sex, brand_type).stream()
                .map(ShuzListResponseDto::new)
                .collect(Collectors.toList());
    }
    //신발 종류 브랜드 별 메뉴
    public List<ShuzListResponseDto> findByBrandTypeOne(char shoes_sex, char shoes_type, String brand_type) {
        return shuzRepository.findByBrandTypeOne(shoes_sex, shoes_type, brand_type).stream()
                .map(ShuzListResponseDto::new)
                .collect(Collectors.toList());
    }
    /* 서브메뉴 */
    @Transactional
    public List<ShuzListResponseDto> findAllDesc() {
        return shuzRepository.findAllDesc().stream()
                .map(ShuzListResponseDto::new)
                .collect(Collectors.toList());
    }
}
