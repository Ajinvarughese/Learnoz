package com.example.AjinProjects.Learnoz.Library;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long commentId;
    private UUID courseId;
    private UUID userId;
    private String password;
    private String userType;
    private String dateTime;

    public Likes(){}

    public Likes(UUID courseId, UUID userId, String password, String userType, String dateTime) {
        this.courseId = courseId;
        this.userId = userId;
        this.password = password;
        this.userType = userType;
        this.dateTime = dateTime;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public UUID getCourseId() {
        return courseId;
    }

    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
