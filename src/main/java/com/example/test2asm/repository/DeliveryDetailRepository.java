package com.example.test2asm.repository;

import com.example.test2asm.entity.DeliveryNoteDetail;
import com.example.test2asm.entity.SaleInvoiceDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DeliveryDetailRepository extends JpaRepository<DeliveryNoteDetail,Integer> {
    @Query(value = "SELECT * FROM deliverydetail ",
            countQuery = "SELECT count(*) FROM deliverydetail ",
            nativeQuery = true)
    Page<DeliveryNoteDetail> findAll(Pageable pageable);
}
