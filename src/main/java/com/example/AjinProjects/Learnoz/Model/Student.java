package com.example.AjinProjects.Learnoz.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String firstName;
    private String sureName;
    private String email;
    private String password;
    private String username;
    private Date regDate;
    private String dob;
    private String gender;

    public Student(String firstName, String sureName, String email, String password, String username, Date regDate, String dob, String gender) {
        this.firstName = firstName;
        this.sureName = sureName;
        this.email = email;
        this.password = password;
        this.username = username;
        this.regDate = regDate;
        this.dob = dob;
        this.gender = gender;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
