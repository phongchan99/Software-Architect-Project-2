package com.example.test2asm.controller;

import com.example.test2asm.entity.ReceivingNoteDetail;
import com.example.test2asm.entity.SaleInvoiceDetail;
import com.example.test2asm.service.ReceivingNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReceivingNoteController {
    @Autowired
    private ReceivingNoteService service;

    @PostMapping("/addReceiving")
    public ReceivingNoteDetail addReceiving(@RequestBody ReceivingNoteDetail receivingNoteDetail) {
        return service.saveReceiving(receivingNoteDetail);
    }

    @PostMapping("/addReceivings")
    public List<ReceivingNoteDetail> addReceivings(@RequestBody List<ReceivingNoteDetail> receivingNoteDetails) {
        return service.saveReceivings(receivingNoteDetails);
    }

//    @GetMapping("/receivings")
//    public List<ReceivingNoteDetail> findReceivings() {
//        return service.getReceivings();
//    }

    @GetMapping( "/receivings/{pageSize},{pageNo}")
    public List<ReceivingNoteDetail> findAll(@PathVariable int pageSize, @PathVariable  int pageNo){
        PageRequest pageable = PageRequest.of(pageNo,pageSize);
        return this.service.findAll(pageable).getContent();
    }

    @GetMapping("/receivingById/{id}")
    public ReceivingNoteDetail findReceivingById(@PathVariable int id) {
        return service.getReceivingById(id);
    }

    @PutMapping("/updateReceiving")
    public ReceivingNoteDetail updateReceiving(@RequestBody ReceivingNoteDetail receivingNoteDetail) {
        return service.updateReceiving(receivingNoteDetail);
    }

    @DeleteMapping("/deleteReceiving/{id}")
    public String deleteReceiving(@PathVariable int id) {
        return service.deleteReceiving(id);
    }
}
