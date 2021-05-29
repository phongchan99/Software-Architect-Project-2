package com.example.test2asm.service;

import com.example.test2asm.entity.SaleInvoiceDetail;
import com.example.test2asm.entity.Staff;
import com.example.test2asm.repository.InvoiceDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
@Service
public class SaleInvoiceService implements Serializable {

    @Autowired
    private InvoiceDetailRepository repository;

    public SaleInvoiceDetail saveInvoice(SaleInvoiceDetail saleInvoiceDetail) {
        return repository.save(saleInvoiceDetail);
    }

    public List<SaleInvoiceDetail> saveInvoices(List<SaleInvoiceDetail> saleInvoiceDetails) {
        return repository.saveAll(saleInvoiceDetails);
    }

    //For testing
    public List<SaleInvoiceDetail> getInvoices() {
        return repository.findAll();
    }

    public Page<SaleInvoiceDetail> findAll(Pageable pageable){
        return (Page<SaleInvoiceDetail>) repository.findAll(pageable);
    }

    public SaleInvoiceDetail getInvoiceById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteInvoice(int id) {
        repository.deleteById(id);
        return "Invoice " + id + " deleted";
    }

    public SaleInvoiceDetail updateInvoice(SaleInvoiceDetail saleInvoiceDetail) {
        SaleInvoiceDetail existInvoice = repository.findById(saleInvoiceDetail.getInvoiceDetail_id()).orElse(null);
        existInvoice.setSaleInvoice(saleInvoiceDetail.getSaleInvoice());
        existInvoice.setProduct(saleInvoiceDetail.getProduct());
        existInvoice.setInvoice_quantity(saleInvoiceDetail.getInvoice_quantity());
        existInvoice.setInvoice_totalPrice(saleInvoiceDetail.getInvoice_totalPrice());
        return repository.save(existInvoice);
    }

    public List<SaleInvoiceDetail> filterByDate(String start, String end) throws ParseException {
        List<SaleInvoiceDetail> qualified = new ArrayList<>();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = format.parse(start);
        Date endDate = format.parse(end);

        List<SaleInvoiceDetail> invoices = repository.findAll();
        for (SaleInvoiceDetail saleInvoiceDetail : invoices) {
            Date mid = format.parse(saleInvoiceDetail.getSaleInvoice().getInvoice_date());
            if (startDate.before(mid) && endDate.after(mid)) {
                qualified.add(saleInvoiceDetail);
            }
        }
        return qualified;
    }


}
