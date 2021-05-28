package com.example.test2asm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "OrderDetail")

public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detail_id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "oorderId", referencedColumnName = "order_id")
    private OOrder order;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "productId", referencedColumnName = "product_id")
    private Product product;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "totalPrice")
    private float price;

    public OrderDetail(OOrder order, Product product, int quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

}
