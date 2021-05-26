package com.example.test2asm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ReceivingNotes")
public class ReceivingNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int receivingNote_id;
    private String receivingNote_date;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "staff", referencedColumnName = "staff_name")
    private Staff staff;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "orderId", referencedColumnName = "order_id")
//    private OOrder order;

    public ReceivingNote(String receiving_date, Staff staff) {
        this.receivingNote_date = receivingNote_date;
        this.staff = staff;
    }


}
