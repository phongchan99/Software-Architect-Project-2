package com.example.test2asm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    private String product_name;
    private String product_model;
    private String product_brand;
    private String product_company;
    private String product_desc;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "category",referencedColumnName = "category_name")
    private Category category;

    private float product_price;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<DeliveryDetail> deliveryDetails;

    public Product(String product_name, String product_model, String product_brand, String product_company, String product_desc, Category category, float product_price) {
        this.product_name = product_name;
        this.product_model = product_model;
        this.product_brand = product_brand;
        this.product_company = product_company;
        this.product_desc = product_desc;
        this.category = category;
        this.product_price = product_price;
    }

    public float getProduct_price() {
        return product_price;
    }
}
