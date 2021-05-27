package com.example.test2asm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Invoice")

public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoice_id;
    private String invoice_date;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "staff",referencedColumnName = "name")
    private Staff staff;

    public Invoice(String invoice_date, Staff staff) {
        this.invoice_date = invoice_date;
        this.staff = staff;
    }
}
