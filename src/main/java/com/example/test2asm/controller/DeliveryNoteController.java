package com.example.test2asm.controller;

import com.example.test2asm.entity.DeliveryNoteDetail;
import com.example.test2asm.entity.ReceivingNoteDetail;
import com.example.test2asm.entity.SaleInvoiceDetail;
import com.example.test2asm.service.DeliveryNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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

//    @GetMapping("/deliveries")
//    public List<DeliveryNoteDetail> findDeliveries() {
//        return service.getDeliveries();
//    }

    @GetMapping( "/deliveries/{pageSize},{pageNo}")
    public List<DeliveryNoteDetail> findAllDelivery(@PathVariable int pageSize, @PathVariable  int pageNo){
        PageRequest pageable = PageRequest.of(pageNo,pageSize);
        return this.service.findAllDelivery(pageable).getContent();
    }

    @GetMapping("/deliveryById/{id}")
    public DeliveryNoteDetail findDeliveryById(@PathVariable int id) {
        return service.getDeliveryById(id);
    }

    @GetMapping("/deliveries")
    public List<DeliveryNoteDetail> findAll() {
        return service.getDeliveries();
    }

    @PutMapping("/updateDelivery")
    public DeliveryNoteDetail updateDelivery(@RequestBody DeliveryNoteDetail deliveryNoteDetail) {
        return service.updateDelivery(deliveryNoteDetail);
    }

    @DeleteMapping("/deleteDelivery/{id}")
    public String deleteDelivery(@PathVariable int id) {
        return service.deleteDelivery(id);
    }

    @GetMapping("/deliveryIn/{start},{end}")
    public List<DeliveryNoteDetail> findInvoiceIn(@PathVariable String start, @PathVariable String end) throws ParseException {
        return service.filterByDate(start, end);
    }

    @GetMapping("/deliveryOn/{date}")
    public List<DeliveryNoteDetail> findInvoiceOn(@PathVariable String date) {
        return service.onDate(date);
    }
}
