package com.shuz.shuzProject.domain.inventory;

import com.shuz.shuzProject.domain.shuz.Shuz;
import com.shuz.shuzProject.domain.store.Store;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor

@Entity
@Table(name ="inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invenNo;
    private String shoesSize;
    private int invenQuantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shoesNo")
    private Shuz shuz;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeNo")
    private Store store;

    @Builder
    public Inventory(Long invenNo, Shuz shuz, Store store, String shoesSize, int invenQuantity) {
        this.invenNo = invenNo;
        this.shuz = shuz;
        this.store = store;
        this.shoesSize = shoesSize;
        this.invenQuantity = invenQuantity;
    }
}
