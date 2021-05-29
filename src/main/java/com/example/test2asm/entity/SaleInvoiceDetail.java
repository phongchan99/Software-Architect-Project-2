package com.example.test2asm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "invoicedetail")

public class SaleInvoiceDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoiceDetail_id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "invoiceId", referencedColumnName = "invoice_id")
    private SaleInvoice saleInvoice;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumns({
            @JoinColumn(name = "productName", referencedColumnName = "product_name"),
            @JoinColumn(name = "productPrice", referencedColumnName = "product_price")
    })
    private Product product;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer", referencedColumnName = "name")
    private Customer customer;

    @Column(name = "Quantity")
    private int invoice_quantity;

    @Column(name = "totalPrice")
    private float invoice_totalPrice;

    public SaleInvoiceDetail(SaleInvoice saleInvoice, Product product, Customer customer, int invoice_quantity) {
        this.saleInvoice = saleInvoice;
        this.product = product;
        this.customer = customer;
        this.invoice_quantity = invoice_quantity;
        this.invoice_totalPrice = product.getProduct_price()*invoice_quantity;
    }

}
