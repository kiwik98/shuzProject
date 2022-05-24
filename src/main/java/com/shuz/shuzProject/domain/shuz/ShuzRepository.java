package com.shuz.shuzProject.domain.shuz;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ShuzRepository extends JpaRepository<Shuz, Long> {

    /* 메인메뉴 */
    // 젠더별 신발 전체 리스트
//    @Query("select s from shoes s where s.shoesSex = :shoesSex")
//    List<Shuz> findByShoesSexAll(@Param("shoesSex") char shoesSex);
    List<Shuz> findByShoesSex(char shoesSex, Pageable pageable);
    // 신발 종류 카테고리 리스트
    List<Shuz> findByShoesSexAndShoesType(char shoesSex, char shoesType, Pageable pageable);
    /* 메인메뉴 */

    /* 서브메뉴 */
    //ALL 브랜드 별 메뉴
    List<Shuz> findByShoesSexAndBrandType(char shoesSex, String brandType, Pageable pageable);
    //신발 종류 브랜드 별 메뉴
    List<Shuz> findByShoesSexAndShoesTypeAndBrandType(char shoesSex, char shoesType, String brandType, Pageable pageable);
    /* 서브메뉴 */

    //검색
    List<Shuz> findByShoesNameContaining(String keyword, Pageable pageable);

    //해당 유저의 위시 리스트
    @Query("select s.shoesNo as shoesNo, s.shoesName as shoesName, s.brandType as brandType, " +
            "s.shoesPrice as shoesPrice, s.shoesImg as shoesImg, w.wishNo as wishNo " +
            "from Shuz s join WishList w on s.shoesNo = w.shoesNo " +
            "where w.userNo = :userNo ")
    List<Map<String, Object>> getWishList(@Param("userNo") long userNo);

    //해당 유저의 위시리스트 등록 상품 수
    @Query("select count(*)" +
            "from Shuz s join WishList w on s.shoesNo = w.shoesNo " +
            "where w.userNo = :userNo ")
    int getWishCount(@Param("userNo") long userNo);
}


