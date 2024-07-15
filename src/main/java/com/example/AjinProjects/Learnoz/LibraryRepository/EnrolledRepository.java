package com.example.AjinProjects.Learnoz.LibraryRepository;

import com.example.AjinProjects.Learnoz.Library.EnrolledStudents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EnrolledRepository extends JpaRepository<EnrolledStudents, Long> {
    @Query("DELETE FROM EnrolledStudents e WHERE e.studentId = :studentId AND e.courseId = :courseId")
    void removeEnrollment(@Param("studentId") UUID studentId, @Param("courseId") UUID courseId);
}
