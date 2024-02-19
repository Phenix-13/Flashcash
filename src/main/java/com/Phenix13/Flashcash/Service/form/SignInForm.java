package com.Phenix13.Flashcash.Service.form;

import lombok.Data;

@Data
public class SignInForm {
    private String email;
    private String password;

    public SignInForm() {
    }

    public SignInForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
