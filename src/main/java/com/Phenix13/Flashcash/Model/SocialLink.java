package com.Phenix13.Flashcash.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SocialLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private User user1;
    @ManyToOne
    private User user2;

    public SocialLink() {
    }

    public SocialLink(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }
}
