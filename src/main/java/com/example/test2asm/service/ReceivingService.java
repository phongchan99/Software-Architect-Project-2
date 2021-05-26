package com.example.test2asm.service;

import com.example.test2asm.entity.ReceivingDetail;
import com.example.test2asm.repository.ReceivingDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceivingService {

    @Autowired
    private ReceivingDetailRepository repository;

    public ReceivingDetail saveReceiving(ReceivingDetail receivingDetail) {
        return repository.save(receivingDetail);
    }

    public List<ReceivingDetail> saveReceivings(List<ReceivingDetail> receivingDetails) {
        return repository.saveAll(receivingDetails);
    }

    public ReceivingDetail getReceivingById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<ReceivingDetail> getReceivings() {
        return repository.findAll();
    }

    public String deleteReceiving(int id) {
        repository.deleteById(id);
        return "Receiving Note number " + id + " deleted";
    }

    public ReceivingDetail updateReceiving(ReceivingDetail receivingDetail) {
        ReceivingDetail existReceiving = repository.findById(receivingDetail.getReceivingdetail_id()).orElse(null);
        existReceiving.setReceiving(receivingDetail.getReceiving());
//        existReceiving.setProduct(receivingDetail.getProduct());
//        existReceiving.setReceivingdetail_quantity(receivingDetail.getReceivingdetail_quantity());
        return repository.save(existReceiving);
    }

}
