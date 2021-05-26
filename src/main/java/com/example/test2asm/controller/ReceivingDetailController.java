package com.example.test2asm.controller;

import com.example.test2asm.entity.ReceivingDetail;
import com.example.test2asm.service.ReceivingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReceivingDetailController {
    @Autowired
    private ReceivingService service;

    @PostMapping("/addReceiving")
    public ReceivingDetail addReceiving(@RequestBody ReceivingDetail receivingDetail) {
        return service.saveReceiving(receivingDetail);
    }

    @PostMapping("/addReceivings")
    public List<ReceivingDetail> addReceivings(@RequestBody List<ReceivingDetail> receivingDetails) {
        return service.saveReceivings(receivingDetails);
    }

    @GetMapping("/receivings")
    public List<ReceivingDetail> findReceivings() {
        return service.getReceivings();
    }

    @GetMapping("/receivingById/{id}")
    public ReceivingDetail findReceivingById(@PathVariable int id) {
        return service.getReceivingById(id);
    }

    @PutMapping("/updateReceiving")
    public ReceivingDetail updateReceiving(@RequestBody ReceivingDetail receivingDetail) {
        return service.updateReceiving(receivingDetail);
    }

    @DeleteMapping("/deleteReceiving/{id}")
    public String deleteReceiving(@PathVariable int id) {
        return service.deleteReceiving(id);
    }
}
