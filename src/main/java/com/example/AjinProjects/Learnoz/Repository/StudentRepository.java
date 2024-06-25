package com.example.AjinProjects.Learnoz.Repository;

import com.example.AjinProjects.Learnoz.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.username = :username AND s.password = :password")
    Optional<Student> findStudentByUsername(@Param("username") String username, @Param("password") String password);

    @Query("SELECT s FROM Student s WHERE s.email = :email AND s.password = :password")
    Optional<Student> findStudentByEmail(@Param("email") String email, @Param("password") String password);

}

