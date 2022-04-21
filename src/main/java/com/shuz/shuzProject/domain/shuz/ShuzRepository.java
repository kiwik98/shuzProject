package com.shuz.shuzProject.domain.shuz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShuzRepository extends JpaRepository<Shuz, Long> {
    @Query("Select s from shoes s ORDER BY s.shoes_no DESC")
    List<Shuz> findAllDesc();

    /* 메인메뉴 */
    // 젠더별 신발 전체 리스트
    @Query("select s from shoes s where s.shoes_sex = :shoes_sex")
    List<Shuz> findByShoesSexAll(@Param("shoes_sex") char shoes_sex);

    // 신발 종류 카테고리 리스트
    @Query("select s from shoes s where s.shoes_sex = :shoes_sex and s.shoes_type = :shoes_type")
    List<Shuz> findByShoesTypeAll(@Param("shoes_sex") char shoes_sex,
                                  @Param("shoes_type") char shoes_type);
    /* 메인메뉴 */

    /* 서브메뉴 */
    //ALL 브랜드 별 메뉴
    @Query("select s from shoes s where s.shoes_sex = :shoes_sex and s.brand_type = :brand_type")
    List<Shuz> findByBrandTypeAll(@Param("shoes_sex") char shoes_sex,
                                  @Param("brand_type") String brand_type);

    //신발 종류 브랜드 별 메뉴
    @Query("select s from shoes s where s.shoes_sex = :shoes_sex and s.shoes_type = :shoes_type and s.brand_type = :brand_type")
    List<Shuz> findByBrandTypeOne(@Param("shoes_sex") char shoes_sex, @Param("shoes_type") char shoes_type,
                                  @Param("brand_type") String brand_type);
    /* 서브메뉴 */
}


