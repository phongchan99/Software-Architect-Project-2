package com.example.test2asm.controller;

import com.example.test2asm.entity.DeliveryNoteDetail;
import com.example.test2asm.service.DeliveryNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeliveryNoteController {

    @Autowired
    private DeliveryNoteService service;

    @PostMapping("/addDelivery")
    public DeliveryNoteDetail addDelivery(@RequestBody DeliveryNoteDetail deliveryNoteDetail) {
        return service.saveDelivery(deliveryNoteDetail);
    }

    @PostMapping("/addDeliveries")
    public List<DeliveryNoteDetail> addDeliveries(@RequestBody List<DeliveryNoteDetail> deliveryNoteDetails) {
        return service.saveDeliveries(deliveryNoteDetails);
    }

    @GetMapping("/deliveries")
    public List<DeliveryNoteDetail> findDeliveries() {
        return service.getDeliveries();
    }

    @GetMapping("/deliveryById/{id}")
    public DeliveryNoteDetail findDeliveryById(@PathVariable int id) {
        return service.getDeliveryById(id);
    }

    @PutMapping("/updateDelivery")
    public DeliveryNoteDetail updateDelivery(@RequestBody DeliveryNoteDetail deliveryNoteDetail) {
        return service.updateDelivery(deliveryNoteDetail);
    }

    @DeleteMapping("/deleteDelivery/{id}")
    public String deleteDelivery(@PathVariable int id) {
        return service.deleteDelivery(id);
    }
}
