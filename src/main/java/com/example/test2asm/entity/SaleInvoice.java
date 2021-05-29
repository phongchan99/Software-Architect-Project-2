package com.example.test2asm.entity;

import com.example.test2asm.service.SaleInvoiceService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Invoice")

public class SaleInvoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoice_id;
    private String invoice_date;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "staff",referencedColumnName = "name")
    private Staff staff;

    public SaleInvoice(String invoice_date, Staff staff) {
        this.invoice_date = invoice_date;
        this.staff = staff;
    }


}
