package com.example.test2asm.controller;

import com.example.test2asm.entity.SaleInvoiceDetail;
import com.example.test2asm.entity.Staff;
import com.example.test2asm.service.SaleInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class SaleInvoiceController {

    @Autowired
    private SaleInvoiceService service;

    @PostMapping("/addInvoice")
    public SaleInvoiceDetail addInvoice(@RequestBody SaleInvoiceDetail saleInvoiceDetail) {
        return service.saveInvoice(saleInvoiceDetail);
    }

    @PostMapping("/addInvoices")
    public List<SaleInvoiceDetail> addInvoices(@RequestBody List<SaleInvoiceDetail> saleInvoiceDetails) {
        return service.saveInvoices(saleInvoiceDetails);
    }

//    @GetMapping("/invoices")
//    public List<SaleInvoiceDetail> findAllInvoices() {
//        return service.getInvoices();
//    }

    @GetMapping( "/invoices/{pageSize},{pageNo}")
    public List<SaleInvoiceDetail> findAll(@PathVariable int pageSize, @PathVariable  int pageNo){
        PageRequest pageable = PageRequest.of(pageNo,pageSize);
        return this.service.findAll(pageable).getContent();
    }

    @GetMapping("/invoiceById/{id}")
    public SaleInvoiceDetail findInvoiceById(@PathVariable int id) {
        return service.getInvoiceById(id);
    }

    @PutMapping("/updateInvoice")
    public SaleInvoiceDetail updateInvoice(@RequestBody SaleInvoiceDetail saleInvoiceDetail) {
        return service.updateInvoice(saleInvoiceDetail);
    }

    @DeleteMapping("/deleteInvoice/{id}")
    public String deleteInvoice(@PathVariable int id) {
        return service.deleteInvoice(id);
    }

    @GetMapping("/invoiceIn/{start},{end}")
    public List<SaleInvoiceDetail> findInvoiceIn(@PathVariable String start, @PathVariable String end) throws ParseException {
        return service.filterByDate(start, end);
    }
}
