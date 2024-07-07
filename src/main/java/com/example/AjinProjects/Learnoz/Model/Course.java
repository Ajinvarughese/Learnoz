package com.example.AjinProjects.Learnoz.Model;

import jakarta.persistence.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Entity
public class Course extends Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long tutorId;
    private String password;
    private String genre;
    private String difficulty;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String dateTime;

    public Course(String url, Integer likes, Float rating, Long id, Long tutorId, String password, String genre, String difficulty, String description, String dateTime) {
        super(url, likes, rating);
        this.id = id;
        this.tutorId = tutorId;
        this.password = password;
        this.genre = genre;
        this.difficulty = difficulty;
        this.description = description;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}