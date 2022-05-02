package com.shuz.shuzProject.domain.store;

import com.shuz.shuzProject.domain.inventory.Inventory;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor

@Entity
@Table(name ="store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeNo;
    private String storeName;
    private String storeLocation;
    private String storeNumber;

    //양방향 맵핑
//    @OneToMany(mappedBy = "store")
//    private List<Inventory> inventory = new ArrayList<>();

    @Builder
    public Store(Long storeNo, String storeName, String storeLocation, String storeNumber) {
        this.storeNo = storeNo;
        this.storeName = storeName;
        this.storeLocation = storeLocation;
        this.storeNumber = storeNumber;
    }
}
