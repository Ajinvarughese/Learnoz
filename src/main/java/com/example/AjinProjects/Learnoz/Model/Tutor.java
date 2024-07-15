package com.example.AjinProjects.Learnoz.Model;

import com.example.AjinProjects.Learnoz.Library.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.UUID;

@Entity
public class Tutor extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    public Tutor() {}
    public Tutor(String firstName, String sureName, String email, String password, String username, String regDate, String dob, String gender, Boolean blockStatus) {
        super(firstName, sureName, email, password, username, regDate, dob, gender, blockStatus);
    }

    public Tutor(String email, String username, String password) {
        super(email, username, password);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
