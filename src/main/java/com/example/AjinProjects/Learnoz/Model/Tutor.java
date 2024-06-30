package com.example.AjinProjects.Learnoz.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Tutor extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Tutor(String firstName, String sureName, String email, String password, String username, Date regDate, String dob, String gender, Long id) {
        super(firstName, sureName, email, password, username, regDate, dob, gender);
        this.id = id;
    }

    public Tutor() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
