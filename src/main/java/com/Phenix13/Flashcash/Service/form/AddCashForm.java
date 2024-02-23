package com.Phenix13.Flashcash.Service.form;

import lombok.Data;

@Data
public class AddCashForm {
    private double cash;

    public AddCashForm(double cash) {
        this.cash = cash;
    }
    public AddCashForm() {
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
}
