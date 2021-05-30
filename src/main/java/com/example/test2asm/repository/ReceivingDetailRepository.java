package com.example.test2asm.repository;

import com.example.test2asm.entity.ReceivingNoteDetail;
import com.example.test2asm.entity.SaleInvoiceDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReceivingDetailRepository extends JpaRepository<ReceivingNoteDetail,Integer> {
    @Query(value = "SELECT * FROM receivingdetail ",
            countQuery = "SELECT count(*) FROM receivingdetail ",
            nativeQuery = true)
    Page<ReceivingNoteDetail> findAllReceiving(Pageable pageable);
}
