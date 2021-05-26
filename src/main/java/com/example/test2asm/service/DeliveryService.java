package com.example.test2asm.service;

import com.example.test2asm.entity.DeliveryDetail;
import com.example.test2asm.repository.DeliveryDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryDetailRepository repository;

    public DeliveryDetail saveDelivery(DeliveryDetail deliveryDetail) {
        return repository.save(deliveryDetail);
    }

    public List<DeliveryDetail> saveDeliveries(List<DeliveryDetail> deliveryDetails) {
        return repository.saveAll(deliveryDetails);
    }

    public DeliveryDetail getDeliveryById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<DeliveryDetail> getDeliveries() {
        return repository.findAll();
    }

    public String deleteDelivery(int id) {
        repository.deleteById(id);
        return "Delivery Note number " + id + " deleted";
    }

    public DeliveryDetail updateDelivery(DeliveryDetail deliveryDetail) {
        DeliveryDetail existDelivery = repository.findById(deliveryDetail.getDeliverydetail_id()).orElse(null);
        existDelivery.setDelivery(deliveryDetail.getDelivery());
        existDelivery.setDelivery_quantity(deliveryDetail.getDelivery_quantity());
        return repository.save(existDelivery);
    }
}
