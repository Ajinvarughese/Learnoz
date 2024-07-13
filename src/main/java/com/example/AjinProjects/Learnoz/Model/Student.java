package com.example.AjinProjects.Learnoz.Model;

import com.example.AjinProjects.Learnoz.Library.User;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
public class Student extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private UUID id;

    public Student(String firstName, String sureName, String email, String password, String username, Date regDate, String dob, String gender, UUID id) {
        super(firstName, sureName, email, password, username, regDate, dob, gender, false);
        this.id = id;
    }
    public Student() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
