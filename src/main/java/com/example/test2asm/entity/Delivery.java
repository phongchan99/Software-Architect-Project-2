package com.example.test2asm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "deliveryNote")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int delivery_id;
    private String delivery_date;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "staff", referencedColumnName = "staff_name")
    private Staff staff;

    public Delivery(String deliveryNote_date, Staff staff) {
        this.delivery_date = delivery_date;
        this.staff = staff;
    }
}
