package com.example.test2asm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Customer")

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;
    private String customer_name;
    private String customer_address;
    private String customer_phone;
    private String customer_fax;
    private String customer_email;
    private String customer_contactPerson;

    public Customer(String customer_name) {
        this.customer_name = customer_name;
    }
}
