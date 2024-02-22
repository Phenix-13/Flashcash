package com.Phenix13.Flashcash.Service.form;

import lombok.Data;

@Data
public class AddIbanForm {
    private String iban1;

    public AddIbanForm() {
    }

    public AddIbanForm(String iban) {
        this.iban1 = iban;
    }

    public String getIban() {
        return iban1;
    }

    public void setIban(String iban) {
        this.iban1 = iban;
    }
}
