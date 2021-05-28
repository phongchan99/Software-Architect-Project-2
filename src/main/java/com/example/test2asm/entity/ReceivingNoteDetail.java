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

public class ReceivingNoteDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int receivingdetail_id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ReceivingNoteId", referencedColumnName = "receivingNote_id")
    private ReceivingNote receivingNote;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "orderDetaiId")
    private OrderDetail orderDetail;

    public ReceivingNoteDetail(ReceivingNote receivingNote, OrderDetail orderDetail) {
        this.receivingNote = receivingNote;
        this.orderDetail = orderDetail;
    }
}
