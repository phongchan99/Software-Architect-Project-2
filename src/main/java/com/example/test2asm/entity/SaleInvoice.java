package com.example.test2asm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Invoice")

public class SaleInvoice {

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