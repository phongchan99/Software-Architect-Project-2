package com.example.test2asm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Customer")

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;
    private String name;
    private String address;
    private String phone;
    private String customer_fax;
    private String customer_email;
    private String customer_contactPerson;

//    @JsonIgnore
//    @OneToMany
//    @JoinColumn(name = "Customer", referencedColumnName = "customer_name")
//    private List<Invoice> invoices;

    public Customer(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
}
