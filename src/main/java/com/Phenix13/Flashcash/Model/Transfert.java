package com.Phenix13.Flashcash.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Transfert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private User user_from;
    @ManyToOne
    private User user_to;
    private double amount_before_fee;
    private double amount_after_fee;
    private Date dateTime;
}
