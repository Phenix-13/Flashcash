package com.Phenix13.Flashcash.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    @NotBlank
    private String password;
    @OneToOne
    private Account account;
    @ManyToMany
    private List<SocialLink> socialLinkList;
}
