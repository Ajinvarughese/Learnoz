package com.example.AjinProjects.Learnoz.Repository;

import com.example.AjinProjects.Learnoz.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
    @Query("SELECT s FROM Student s WHERE s.username = :username AND s.password = :password")
    Optional<Student> findStudentByUsername(@Param("username") String username, @Param("password") String password);

    @Query("SELECT s FROM Student s WHERE s.email = :email AND s.password = :password")
    Optional<Student> findStudentByEmail(@Param("email") String email, @Param("password") String password);

    @Query("SELECT s FROM Student s WHERE s.id = :id AND s.password = :password")
    Optional<Student> findStudentById(@Param("id") UUID id, @Param("password") String password);

    @Query("SELECT s FROM Student s WHERE s.email = :email")
    Optional<Student> findStudentByEmailOnly(@Param("email") String email);

}

