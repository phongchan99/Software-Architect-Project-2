package com.example.test2asm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Staff")
public class Staff implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staff_id;
    private String name;
    private String staff_address;
    private String staff_phone;
    private String staff_email;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Staff", referencedColumnName = "name")
    private List<OOrder> order;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "saleStaff", referencedColumnName = "name")
    private List<SaleInvoice> saleInvoices;

    public Staff(String name, String staff_address, String staff_phone, String staff_email) {
        this.name = name;
        this.staff_address = staff_address;
        this.staff_phone = staff_phone;
        this.staff_email = staff_email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStaff_address() {
        return staff_address;
    }

    public void setStaff_address(String staff_address) {
        this.staff_address = staff_address;
    }

    public String getStaff_phone() {
        return staff_phone;
    }

    public void setStaff_phone(String staff_phone) {
        this.staff_phone = staff_phone;
    }

    public String getStaff_email() {
        return staff_email;
    }

    public void setStaff_email(String staff_email) {
        this.staff_email = staff_email;
    }
}
