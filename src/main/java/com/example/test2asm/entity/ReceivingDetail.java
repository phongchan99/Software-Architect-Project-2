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

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "orderDetaiId")
    private OrderDetail orderDetail;

    public ReceivingDetail(Receiving receiving, OrderDetail orderDetail) {
        this.receiving = receiving;
        this.orderDetail = orderDetail;
    }
}
