package com.example.test2asm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

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
    private ReceivingNote receivingNote;

//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "productId", referencedColumnName = "product_id")
//    private Product product;

    @OneToOne
    @JoinColumn(name = "orderDetaiId")
    private OrderDetail orderDetail;

//    @Column(name = "Quantity")
//    private int receivingdetail_quantity;


    public ReceivingDetail(ReceivingNote receivingNote, OrderDetail orderDetail) {
        this.receivingNote = receivingNote;
        this.orderDetail = orderDetail;
    }
}
