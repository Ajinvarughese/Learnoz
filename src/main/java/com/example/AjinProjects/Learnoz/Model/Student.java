package com.example.AjinProjects.Learnoz.Model;

import com.example.AjinProjects.Learnoz.Library.User;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
public class Student extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    public Student(){}

    public Student(String firstName, String sureName, String email, String password, String username, String regDate, String dob, String gender, Boolean blockStatus) {
        super(firstName, sureName, email, password, username, regDate, dob, gender, blockStatus);
    }

    //for login
    public Student(String email, String username, String password) {
        super(email, username, password);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
