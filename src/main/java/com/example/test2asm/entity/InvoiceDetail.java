package com.example.test2asm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "InvoiceDetail")

public class InvoiceDetail {

    @Id
    @GeneratedValue
    private int invoiceDetail_id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "invoiceId", referencedColumnName = "invoice_id")
    private Invoice invoice;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumns({
            @JoinColumn(name = "productId", referencedColumnName = "product_id"),
            @JoinColumn(name = "productPrice", referencedColumnName = "product_price")
    })
    private Product product;

    @Column(name = "Quantity")
    private int invoice_quantity;


}
