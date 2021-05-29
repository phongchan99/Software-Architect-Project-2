package com.example.test2asm.repository;

import com.example.test2asm.entity.SaleInvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
@Repository
public interface InvoiceDetailRepository extends JpaRepository<SaleInvoiceDetail,Integer> {
}
