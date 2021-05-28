package com.example.test2asm.service;

import com.example.test2asm.entity.ReceivingNoteDetail;
import com.example.test2asm.repository.ReceivingDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceivingNoteService {

    @Autowired
    private ReceivingDetailRepository repository;

    public ReceivingNoteDetail saveReceiving(ReceivingNoteDetail receivingNoteDetail) {
        return repository.save(receivingNoteDetail);
    }

    public List<ReceivingNoteDetail> saveReceivings(List<ReceivingNoteDetail> receivingNoteDetails) {
        return repository.saveAll(receivingNoteDetails);
    }

    public ReceivingNoteDetail getReceivingById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<ReceivingNoteDetail> getReceivings() {
        return repository.findAll();
    }

    public String deleteReceiving(int id) {
        repository.deleteById(id);
        return "Receiving Note number " + id + " deleted";
    }

    public ReceivingNoteDetail updateReceiving(ReceivingNoteDetail receivingNoteDetail) {
        ReceivingNoteDetail existReceiving = repository.findById(receivingNoteDetail.getReceivingDetail_id()).orElse(null);
        existReceiving.setReceivingNote(receivingNoteDetail.getReceivingNote());
//        existReceiving.setProduct(receivingDetail.getProduct());
//        existReceiving.setReceivingdetail_quantity(receivingDetail.getReceivingdetail_quantity());
        return repository.save(existReceiving);
    }

}
