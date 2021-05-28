package com.example.test2asm.service;

import com.example.test2asm.entity.SaleInvoiceDetail;
import com.example.test2asm.repository.InvoiceDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleInvoiceService {

    @Autowired
    private InvoiceDetailRepository repository;

    public SaleInvoiceDetail saveInvoice(SaleInvoiceDetail saleInvoiceDetail) {
        return repository.save(saleInvoiceDetail);
    }

    public List<SaleInvoiceDetail> saveInvoices(List<SaleInvoiceDetail> saleInvoiceDetails) {
        return repository.saveAll(saleInvoiceDetails);
    }

    public List<SaleInvoiceDetail> getInvoices() {
        return repository.findAll();
    }

    public SaleInvoiceDetail getInvoiceById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteInvoice(int id) {
        repository.deleteById(id);
        return "Invoice " + id + " deleted";
    }

    public SaleInvoiceDetail updateInvoice(SaleInvoiceDetail saleInvoiceDetail) {
        SaleInvoiceDetail existInvoice = repository.findById(saleInvoiceDetail.getInvoiceDetail_id()).orElse(null);
        existInvoice.setSaleInvoice(saleInvoiceDetail.getSaleInvoice());
        existInvoice.setProduct(saleInvoiceDetail.getProduct());
        existInvoice.setInvoice_quantity(saleInvoiceDetail.getInvoice_quantity());
        existInvoice.setInvoice_totalPrice(saleInvoiceDetail.getInvoice_totalPrice());
        return repository.save(existInvoice);
    }
}