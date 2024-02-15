package com.Phenix13.Flashcash.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SocialLink {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private User user1;
    @ManyToOne
    private User user2;
}
