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

public class DeliveryDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deliverydetail_id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "DeliveryNoteId", referencedColumnName = "delivery_id")
    private Delivery delivery;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Product product;

    @Column(name = "Quantity")
    private int delivery_quantity;

    public DeliveryDetail(Delivery delivery, int delivery_quantity) {
        this.delivery = delivery;
        this.delivery_quantity = delivery_quantity;
    }
}
