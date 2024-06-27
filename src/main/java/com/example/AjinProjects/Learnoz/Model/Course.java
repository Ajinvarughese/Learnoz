package com.example.AjinProjects.Learnoz.Model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Course extends Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long tutor_id;
    private String genre;
    private String difficulty;
    @Column(columnDefinition = "TEXT")
    private String description;
    @OneToMany(mappedBy = "course")
    private List<EnrolledStudents> enrolledStudents;
    private Date date;

    public Course(String url, Integer likes, Float rating, Long id, Long tutor_id, String genre, String difficulty, String description, Date date) {
        super(url, likes, rating);
        this.id = id;
        this.tutor_id = tutor_id;
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

    public Long getTutor_id() {
        return tutor_id;
    }

    public void setTutor_id(Long tutor_id) {
        this.tutor_id = tutor_id;
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

@Entity
class EnrolledStudents {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long enrollId;
    private Long studentId;
    private Long courseId;

    public EnrolledStudents(Long enrollId, Long studentId, Long courseId) {
        this.enrollId = enrollId;
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public EnrolledStudents(){}

    public Long getEnrollId() {
        return enrollId;
    }

    public void setEnrollId(Long enrollId) {
        this.enrollId = enrollId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}