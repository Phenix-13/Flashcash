package com.Phenix13.Flashcash.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double amount;
    @Column(unique = true)
    private String iban1;
    @Column(unique = true)
    private String iban2;
    @Column(unique = true)
    private String iban3;
    @Column(unique = true)
    private String iban4;
    @Column(unique = true)
    private String iban5;

    public Account() {
    }



    public Account(int id, double amount, String iban1, String iban2, String iban3, String iban4, String iban5) {
        this.id = id;
        this.amount = amount;
        this.iban1 = iban1;
        this.iban2 = iban2;
        this.iban3 = iban3;
        this.iban4 = iban4;
        this.iban5 = iban5;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getIban1() {
        return iban1;
    }

    public void setIban1(String iban1) {
        this.iban1 = iban1;
    }

    public String getIban2() {
        return iban2;
    }

    public void setIban2(String iban2) {
        this.iban2 = iban2;
    }

    public String getIban3() {
        return iban3;
    }

    public void setIban3(String iban3) {
        this.iban3 = iban3;
    }

    public String getIban4() {
        return iban4;
    }

    public void setIban4(String iban4) {
        this.iban4 = iban4;
    }

    public String getIban5() {
        return iban5;
    }

    public void setIban5(String iban5) {
        this.iban5 = iban5;
    }
}
