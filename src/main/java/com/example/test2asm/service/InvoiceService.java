package com.example.test2asm.service;

import com.example.test2asm.entity.InvoiceDetail;
import com.example.test2asm.repository.InvoiceDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceDetailRepository repository;

    public InvoiceDetail saveInvoice(InvoiceDetail invoiceDetail) {
        return repository.save(invoiceDetail);
    }

    public List<InvoiceDetail> saveInvoices(List<InvoiceDetail> invoiceDetails) {
        return repository.saveAll(invoiceDetails);
    }

    public List<InvoiceDetail> getInvoices() {
        return repository.findAll();
    }

    public InvoiceDetail getInvoiceById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteInvoice(int id) {
        repository.deleteById(id);
        return "Invoice " + id + " deleted";
    }

    public InvoiceDetail updateInvoice(InvoiceDetail invoiceDetail) {
        InvoiceDetail existInvoice = repository.findById(invoiceDetail.getInvoiceDetail_id()).orElse(null);
        existInvoice.setInvoice(invoiceDetail.getInvoice());
        existInvoice.setProduct(invoiceDetail.getProduct());
        existInvoice.setInvoice_quantity(invoiceDetail.getInvoice_quantity());
        existInvoice.setInvoice_totalPrice(invoiceDetail.getInvoice_totalPrice());
        return repository.save(existInvoice);
    }
}
