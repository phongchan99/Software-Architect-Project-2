package com.example.test2asm.service;

import com.example.test2asm.entity.DeliveryNoteDetail;
import com.example.test2asm.entity.ReceivingNoteDetail;
import com.example.test2asm.entity.SaleInvoiceDetail;
import com.example.test2asm.repository.DeliveryDetailRepository;
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
public class DeliveryNoteService {

    @Autowired
    private DeliveryDetailRepository repository;
    @Autowired
    private ReceivingNoteService receivingNoteService;

    public DeliveryNoteDetail saveDelivery(DeliveryNoteDetail deliveryNoteDetail) {
        return repository.save(deliveryNoteDetail);
    }

    public List<DeliveryNoteDetail> saveDeliveries(List<DeliveryNoteDetail> deliveryNoteDetails) {
        return repository.saveAll(deliveryNoteDetails);
    }

    public DeliveryNoteDetail getDeliveryById(int id) {
        return repository.findById(id).orElse(null);
    }

    //For testing
    public List<DeliveryNoteDetail> getDeliveries() {
        return repository.findAll();
    }

    public Page<DeliveryNoteDetail> findAllDelivery(Pageable pageable){
        return (Page<DeliveryNoteDetail>) repository.findAllDelivery(pageable);
    }

    public String deleteDelivery(int id) {
        repository.deleteById(id);
        return "Delivery Note number " + id + " deleted";
    }

    public DeliveryNoteDetail updateDelivery(DeliveryNoteDetail deliveryNoteDetail) {
        DeliveryNoteDetail existDelivery = repository.findById(deliveryNoteDetail.getDeliveryDetail_id()).orElse(null);
        existDelivery.setDeliveryNote(deliveryNoteDetail.getDeliveryNote());
        existDelivery.setQuantity(deliveryNoteDetail.getQuantity());
        return repository.save(existDelivery);
    }

    public List<DeliveryNoteDetail> filterByDate(String start, String end) throws ParseException {
        List<DeliveryNoteDetail> qualified = new ArrayList<>();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = format.parse(start);
        Date endDate = format.parse(end);

        List<DeliveryNoteDetail> notes = repository.findAll();
        for (DeliveryNoteDetail deliveryNoteDetail : notes) {
            Date mid = format.parse(deliveryNoteDetail.getDeliveryNote().getDeliveryNote_date());
            if (startDate.before(mid) && endDate.after(mid)) {
                qualified.add(deliveryNoteDetail);
            }
        }
        return qualified;
    }

    public List<DeliveryNoteDetail> onDate(String date) {
        List<DeliveryNoteDetail> filtered = new ArrayList<>();
        List<DeliveryNoteDetail> invoices = repository.findAll();
        for (DeliveryNoteDetail deliveryNoteDetail : invoices) {
            if (deliveryNoteDetail.getDeliveryNote().getDeliveryNote_date().equals(date)) {
                filtered.add(deliveryNoteDetail);
            }
        }
        return filtered;
    }

    public String warehouse(String name, String start, String end) throws ParseException {
        List<Integer> received = new ArrayList<>();
        List<Integer> delivered = new ArrayList<>();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = format.parse(start);
        Date endDate = format.parse(end);

        List<ReceivingNoteDetail> receiveNotes = receivingNoteService.getReceivings();
        List<DeliveryNoteDetail> deliveryNotes = repository.findAll();

        for (DeliveryNoteDetail deliveryNoteDetail : deliveryNotes) {
            Date mid = format.parse(deliveryNoteDetail.getDeliveryNote().getDeliveryNote_date());
            if (startDate.before(mid) && endDate.after(mid)) {
                if (deliveryNoteDetail.getProduct().getProduct_name()
                        .toLowerCase().equals(name.toLowerCase())) {
                    delivered.add(deliveryNoteDetail.getQuantity());
                }
            }
        }
        for (ReceivingNoteDetail receivingNoteDetail : receiveNotes) {
            Date mid = format.parse(receivingNoteDetail.getReceivingNote().getReceivingNote_date());
            if (startDate.before(mid) && endDate.after(mid)) {
                if (receivingNoteDetail.getOrderDetail().getProduct().getProduct_name()
                        .toLowerCase().equals(name.toLowerCase())) {
                    received.add(receivingNoteDetail.getOrderDetail().getQuantity());
                }
            }
        }

        int balance = 0;
        return  "The number of " + name.toUpperCase() + " received are: " + received + "\n"
                + "The number of " + name.toUpperCase() + " delivered are: " + delivered + "\n"
                + "The balance remaining: " + received + " - " + delivered + " = "
                + "I didn't figure this part out so please do the calculation in you mind" + ".";
    }
}
