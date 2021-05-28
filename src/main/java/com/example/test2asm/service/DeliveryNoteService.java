package com.example.test2asm.service;

import com.example.test2asm.entity.DeliveryNoteDetail;
import com.example.test2asm.repository.DeliveryDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryNoteService {

    @Autowired
    private DeliveryDetailRepository repository;

    public DeliveryNoteDetail saveDelivery(DeliveryNoteDetail deliveryNoteDetail) {
        return repository.save(deliveryNoteDetail);
    }

    public List<DeliveryNoteDetail> saveDeliveries(List<DeliveryNoteDetail> deliveryNoteDetails) {
        return repository.saveAll(deliveryNoteDetails);
    }

    public DeliveryNoteDetail getDeliveryById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<DeliveryNoteDetail> getDeliveries() {
        return repository.findAll();
    }

    public String deleteDelivery(int id) {
        repository.deleteById(id);
        return "Delivery Note number " + id + " deleted";
    }

    public DeliveryNoteDetail updateDelivery(DeliveryNoteDetail deliveryNoteDetail) {
        DeliveryNoteDetail existDelivery = repository.findById(deliveryNoteDetail.getDeliverydetail_id()).orElse(null);
        existDelivery.setDeliveryNote(deliveryNoteDetail.getDeliveryNote());
        existDelivery.setDelivery_quantity(deliveryNoteDetail.getDelivery_quantity());
        return repository.save(existDelivery);
    }
}
