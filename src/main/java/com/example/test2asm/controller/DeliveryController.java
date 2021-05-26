package com.example.test2asm.controller;

import com.example.test2asm.entity.DeliveryDetail;
import com.example.test2asm.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeliveryController {

    @Autowired
    private DeliveryService service;

    @PostMapping("/addDelivery")
    public DeliveryDetail addDelivery(@RequestBody DeliveryDetail deliveryDetail) {
        return service.saveDelivery(deliveryDetail);
    }

    @PostMapping("/addDeliveries")
    public List<DeliveryDetail> addDeliveries(@RequestBody List<DeliveryDetail> deliveryDetails) {
        return service.saveDeliveries(deliveryDetails);
    }

    @GetMapping("/deliveries")
    public List<DeliveryDetail> findDeliveries() {
        return service.getDeliveries();
    }

    @GetMapping("/deliveryById/{id}")
    public DeliveryDetail findDeliveryById(@PathVariable int id) {
        return service.getDeliveryById(id);
    }

    @PutMapping("/updateDelivery")
    public DeliveryDetail updateDelivery(@RequestBody DeliveryDetail deliveryDetail) {
        return service.updateDelivery(deliveryDetail);
    }

    @DeleteMapping("/deleteDelivery/{id}")
    public String deleteDelivery(@PathVariable int id) {
        return service.deleteDelivery(id);
    }
}
