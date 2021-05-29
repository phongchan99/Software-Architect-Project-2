package com.example.test2asm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Customer")

public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;
    private String name;
    private String address;
    private String phone;
    private String customer_fax;
    private String customer_email;
    private String customer_contactPerson;

    public Customer(String name, String address, String phone, String customer_fax, String customer_email, String customer_contactPerson) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.customer_fax = customer_fax;
        this.customer_email = customer_email;
        this.customer_contactPerson = customer_contactPerson;
    }
}
