package com.example.test2asm.repository;

import com.example.test2asm.entity.SaleInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<SaleInvoice,Integer> {
}
