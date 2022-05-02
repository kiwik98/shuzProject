package com.shuz.shuzProject.domain.shuz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShuzRepository extends JpaRepository<Shuz, Long> {

    /* 메인메뉴 */
    // 젠더별 신발 전체 리스트
//    @Query("select s from shoes s where s.shoesSex = :shoesSex")
//    List<Shuz> findByShoesSexAll(@Param("shoesSex") char shoesSex);
    List<Shuz> findByShoesSex(char shoesSex);
    // 신발 종류 카테고리 리스트
    List<Shuz> findByShoesSexAndShoesType(char shoesSex, char shoesType);
    /* 메인메뉴 */

    /* 서브메뉴 */
    //ALL 브랜드 별 메뉴
    List<Shuz> findByShoesSexAndBrandType(char shoesSex, String brandType);
    //신발 종류 브랜드 별 메뉴
    List<Shuz> findByShoesSexAndShoesTypeAndBrandType(char shoesSex, char shoesType, String brandType);
    /* 서브메뉴 */
}


