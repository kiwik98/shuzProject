package com.shuz.shuzProject.domain.wishlist;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;

import javax.persistence.*;

@Getter
@NoArgsConstructor

@Entity
@Table(name ="wishlist")
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wishNo;
    private Long userNo;
    private Long shoesNo;

    @Builder
    public WishList(Long wishNo, Long userNo, Long shoesNo) {
        this.wishNo = wishNo;
        this.userNo = userNo;
        this.shoesNo = shoesNo;
    }
}
