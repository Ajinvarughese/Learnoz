package com.example.AjinProjects.Learnoz.Model;

import com.example.AjinProjects.Learnoz.Library.Video;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Course extends Video {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private UUID id;
    private Long tutorId;
    private String password;
    private String genre;
    private String difficulty;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String dateTime;

    public Course(String url, Integer likes, Integer views, UUID id, Long tutorId, String password, String genre, String difficulty, String description, String dateTime) {
        super(url, likes, views);
        this.id = id;
        this.tutorId = tutorId;
        this.password = password;
        this.genre = genre;
        this.difficulty = difficulty;
        this.description = description;
        this.dateTime = dateTime;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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