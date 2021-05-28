package com.example.test2asm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class Provider implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int provider_id;
    private String provider_name;
    private String provider_address;
    private String provider_phone;
    private String provider_fax;
    private String provider_email;
    private String provider_contactPerson;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Provider", referencedColumnName = "provider_name")
    private List<OOrder> order;

    public Provider(String provider_name, String provider_address, String provider_phone, String provider_fax, String provider_email, String provider_contactPerson) {
        this.provider_name = provider_name;
        this.provider_address = provider_address;
        this.provider_phone = provider_phone;
        this.provider_fax = provider_fax;
        this.provider_email = provider_email;
        this.provider_contactPerson = provider_contactPerson;
    }
}
