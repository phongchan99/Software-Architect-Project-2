package com.example.test2asm.controller;

import com.example.test2asm.entity.InvoiceDetail;
import com.example.test2asm.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    private InvoiceService service;

    @PostMapping("/addInvoice")
    public InvoiceDetail addInvoice(@RequestBody InvoiceDetail invoiceDetail) {
        return service.saveInvoice(invoiceDetail);
    }

    @PostMapping("/addInvoices")
    public List<InvoiceDetail> addInvoices(@RequestBody List<InvoiceDetail> invoiceDetails) {
        return service.saveInvoices(invoiceDetails);
    }

    @GetMapping("/invoices")
    public List<InvoiceDetail> findAllInvoices() {
        return service.getInvoices();
    }

    @GetMapping("/invoiceById/{id}")
    public InvoiceDetail findInvoiceById(@PathVariable int id) {
        return service.getInvoiceById(id);
    }

    @PutMapping("/updateInvoice")
    public InvoiceDetail updateInvoice(@RequestBody InvoiceDetail invoiceDetail) {
        return service.updateInvoice(invoiceDetail);
    }

    @DeleteMapping("/deleteInvoice/{id}")
    public String deleteInvoice(@PathVariable int id) {
        return service.deleteInvoice(id);
    }
}
