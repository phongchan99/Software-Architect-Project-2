package com.example.test2asm.repository;

import com.example.test2asm.entity.SaleInvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceDetailRepository extends JpaRepository<SaleInvoiceDetail,Integer> {
}
