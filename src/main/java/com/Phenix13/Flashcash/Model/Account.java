package com.Phenix13.Flashcash.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double amount;
    @Column(unique = true)
    private String iban;
}
