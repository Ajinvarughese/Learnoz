package com.example.AjinProjects.Learnoz.Library;

import jakarta.persistence.*;

import java.util.Date;

@MappedSuperclass
public class User {
    private String firstName;
    private String sureName;
    private String email;
    private String password;
    private String username;
    private String regDate;
    private String dob;
    private String gender;
    private Boolean blockStatus;

    public User(String firstName, String sureName, String email, String password, String username, String regDate, String dob, String gender, Boolean blockStatus) {
        this.firstName = firstName;
        this.sureName = sureName;
        this.email = email;
        this.password = password;
        this.username = username;
        this.regDate = regDate;
        this.dob = dob;
        this.gender = gender;
        this.blockStatus = blockStatus;
    }
    public User(){}
    //for login
    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
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

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
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

    public Boolean getBlockStatus() {
        return blockStatus;
    }

    public void setBlockStatus(Boolean blockStatus) {
        this.blockStatus = blockStatus;
    }
}
