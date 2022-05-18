package com.shuz.shuzProject.domain.wishlist;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface WishListRepository extends JpaRepository<WishList, Long> {

//    @Transactional
//    @Query("select count (w.wishNo) > 0 " +
//            "from wishlist w " +
//            "where w.userNo =:userNo and w.shoesNo =:shoesNo")
//    boolean wishCheck(@Param("userNo") Long userNo, @Param("shoesNo") Long shoesNo);
    WishList findByUserNoAndShoesNo(Long userNo, Long shoesNo);

    boolean existsByUserNoAndShoesNo(Long userNo, Long shoesNo);
}
