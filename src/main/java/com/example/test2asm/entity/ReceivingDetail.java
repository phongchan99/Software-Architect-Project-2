package com.example.test2asm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ReceivingDetail")

public class ReceivingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int receivingdetail_id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ReceivingNoteId", referencedColumnName = "receivingNote_id")
    private Receiving receiving;

//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "productId", referencedColumnName = "product_id")
//    private Product product;

    @OneToOne
    @JoinColumn(name = "orderDetaiId")
    private OrderDetail orderDetail;

//    @Column(name = "Quantity")
//    private int receivingdetail_quantity;


    public ReceivingDetail(Receiving receiving, OrderDetail orderDetail) {
        this.receiving = receiving;
        this.orderDetail = orderDetail;
    }
}
