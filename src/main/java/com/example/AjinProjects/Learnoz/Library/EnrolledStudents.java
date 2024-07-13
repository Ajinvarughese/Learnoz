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
