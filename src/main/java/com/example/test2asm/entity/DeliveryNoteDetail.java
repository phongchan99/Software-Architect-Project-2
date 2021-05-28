package com.example.test2asm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DeliveryDetail")

public class DeliveryNoteDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deliveryDetail_id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "DeliveryNoteId", referencedColumnName = "deliveryNote_id")
    private DeliveryNote deliveryNote;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product", referencedColumnName = "product_name")
    private Product product;

    @Column(name = "Quantity")
    private int quantity;

    public DeliveryNoteDetail(DeliveryNote deliveryNote, Product product, int quantity) {
        this.deliveryNote = deliveryNote;
        this.product = product;
        this.quantity = quantity;
    }
}
