package com.shuz.shuzProject.domain.shuz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShuzRepository extends JpaRepository<Shuz, Long> {
    @Query("Select s from shoes s ORDER BY s.shoes_no DESC")
    List<Shuz> findAllDesc();

    @Query("select s from shoes s where s.shoes_sex = :shoes_sex")
    List<Shuz> findByShoesSexAll(@Param("shoes_sex") char shoes_sex);

    @Query("select s from shoes s where s.shoes_sex = :shoes_sex and s.shoes_type = :shoes_type")
    List<Shuz> findByShoesTypeAll(@Param("shoes_sex") char shoes_sex,
                                  @Param("shoes_type") char shoes_type);
}


