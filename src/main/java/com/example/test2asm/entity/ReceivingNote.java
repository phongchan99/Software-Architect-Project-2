package com.example.test2asm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ReceivingNote")
public class ReceivingNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int receivingNote_id;
    private Date receivingNote_date;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "staff", referencedColumnName = "name")
    private Staff staff;

    public ReceivingNote(String receiving_date, Staff staff) {
        this.receivingNote_date = receivingNote_date;
        this.staff = staff;
    }


}
