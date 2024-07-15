package com.example.AjinProjects.Learnoz.Library;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class EnrolledStudents {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long enrollId;
    private UUID studentId;
    private UUID courseId;

    public EnrolledStudents(Long enrollId, UUID studentId, UUID courseId) {
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

    public UUID getStudentId() {
        return studentId;
    }

    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
    }

    public UUID getCourseId() {
        return courseId;
    }

    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }
}
