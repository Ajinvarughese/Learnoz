package com.example.AjinProjects.Learnoz.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Course extends Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long tutorId;
    private String genre;
    private String difficulty;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Date date;

    public Course(String url, Integer likes, Float rating, Long id, Long tutor_id, String genre, String difficulty, String description, Date date) {
        super(url, likes, rating);
        this.id = id;
        this.tutorId = tutor_id;
        this.genre = genre;
        this.difficulty = difficulty;
        this.description = description;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}