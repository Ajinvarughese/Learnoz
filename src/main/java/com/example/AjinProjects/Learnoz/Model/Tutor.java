package com.example.AjinProjects.Learnoz.Model;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Tutor extends User {
    public Tutor(String firstName, String sureName, String email, String password, String username, Date regDate, String dob, String gender) {
        super(firstName, sureName, email, password, username, regDate, dob, gender);
    }
    public Tutor(){}
}
