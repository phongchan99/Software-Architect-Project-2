package com.example.test2asm.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OOrder")
public class OOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    private String order_date;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "staff",referencedColumnName = "staff_name")
    private Staff staff;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "provider",referencedColumnName = "provider_name")
    private Provider provider;

    @JsonIgnore
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    public OOrder(String order_date, Staff staff, Provider provider) {
        this.order_date = order_date;
        this.staff = staff;
        this.provider = provider;
    }
}
