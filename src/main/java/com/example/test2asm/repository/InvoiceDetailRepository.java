package com.example.test2asm.repository;

import com.example.test2asm.entity.SaleInvoiceDetail;
import com.example.test2asm.entity.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface InvoiceDetailRepository extends JpaRepository<SaleInvoiceDetail,Integer> {
    @Query(value = "SELECT * FROM invoicedetail ",
            countQuery = "SELECT count(*) FROM invoicedetail ",
            nativeQuery = true)
    Page<SaleInvoiceDetail> findAll(Pageable pageable);
}
