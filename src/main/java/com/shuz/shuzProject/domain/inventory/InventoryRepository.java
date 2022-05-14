package com.shuz.shuzProject.domain.inventory;

import com.shuz.shuzProject.domain.shuz.Shuz;
import com.shuz.shuzProject.web.dto.ShuzInvenResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {


    @Query(value = "select st.storeName as storeName, st.storeLocation as storeLocation," +
            " st.storeNumber as storeNumber, i.invenQuantity as invenQuantity, i.invenNo as invenNo " +
            "from Inventory i join i.store st on i.store = st.storeNo " +
            "join i.shuz sz on i.shuz = sz.shoesNo where sz.shoesNo = :shoesNo " +
            "and i.shoesSize = :shoesSize ")
    List<Map<String, Object>> findInvenSearch(@Param("shoesNo") Long shoesNo,
                                                  @Param("shoesSize") String shoesSize);

    @Transactional
    @Modifying
    @Query(value = "update inventory SET inven_quantity = :invenQuantity where inven_no = :invenNo", nativeQuery = true)
    int updateQuantity(@Param("invenQuantity") int invenQuantity, @Param("invenNo") Long invenNo);

}
