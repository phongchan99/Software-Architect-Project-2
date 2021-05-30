package com.example.test2asm.service;

import com.example.test2asm.entity.DeliveryNoteDetail;
import com.example.test2asm.entity.ReceivingNoteDetail;
import com.example.test2asm.entity.SaleInvoiceDetail;
import com.example.test2asm.repository.ReceivingDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    //For testing
    public List<ReceivingNoteDetail> getReceivings() {
        return repository.findAll();
    }

    public Page<ReceivingNoteDetail> findAllReceiving(Pageable pageable){
        return (Page<ReceivingNoteDetail>) repository.findAllReceiving(pageable);
    }

    public String deleteReceiving(int id) {
        repository.deleteById(id);
        return "Receiving Note number " + id + " deleted";
    }

    public ReceivingNoteDetail updateReceiving(ReceivingNoteDetail receivingNoteDetail) {
        ReceivingNoteDetail existReceiving = repository.findById(receivingNoteDetail.getReceivingDetail_id()).orElse(null);
        existReceiving.setReceivingNote(receivingNoteDetail.getReceivingNote());
        return repository.save(existReceiving);
    }

    public List<ReceivingNoteDetail> filterByDate(String start, String end) throws ParseException {
        List<ReceivingNoteDetail> qualified = new ArrayList<>();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = format.parse(start);
        Date endDate = format.parse(end);

        List<ReceivingNoteDetail> invoices = repository.findAll();
        for (ReceivingNoteDetail receivingNoteDetail : invoices) {
            Date mid = format.parse(receivingNoteDetail.getReceivingNote().getReceivingNote_date());
            if (startDate.before(mid) && endDate.after(mid)) {
                qualified.add(receivingNoteDetail);
            }
        }
        return qualified;
    }

    public List<ReceivingNoteDetail> onDate(String date) {
        List<ReceivingNoteDetail> filtered = new ArrayList<>();
        List<ReceivingNoteDetail> invoices = repository.findAll();
        for (ReceivingNoteDetail receivingNoteDetail : invoices) {
            if (receivingNoteDetail.getReceivingNote().getReceivingNote_date().equals(date)) {
                filtered.add(receivingNoteDetail);
            }
        }
        return filtered;
    }

    public String warehouse(String name, String start, String end) throws ParseException {
        List received = new ArrayList<>();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = format.parse(start);
        Date endDate = format.parse(end);

        List<ReceivingNoteDetail> receiveNotes = repository.findAll();

        for (ReceivingNoteDetail receivingNoteDetail : receiveNotes) {
            Date mid = format.parse(receivingNoteDetail.getReceivingNote().getReceivingNote_date());
            if (startDate.before(mid) && endDate.after(mid)) {
                if (receivingNoteDetail.getOrderDetail().getProduct().getProduct_name().toLowerCase().equals(name.toLowerCase())) {
                    received.add(receivingNoteDetail.getOrderDetail().getQuantity());
                }
            }
        }
        return "The number of " + name + " received are: " + received;
    }

}
