package com.shuz.shuzProject.domain.shuz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShuzRepository extends JpaRepository<Shuz, Long> {
    @Query("Select s from shoes s ORDER BY s.shoes_no DESC")
    List<Shuz> findAllDesc();

    @Query("select s from shoes s where s.shoes_type = :shoes_type")
    List<Shuz> findByShoesTypeAll(@Param("shoes_type") char shoes_type);
}
