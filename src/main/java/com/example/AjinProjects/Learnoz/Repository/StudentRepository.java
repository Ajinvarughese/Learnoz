package com.example.AjinProjects.Learnoz.Repository;

import com.example.AjinProjects.Learnoz.Model.Student;
import com.example.AjinProjects.Learnoz.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.username = :username AND s.password = :password")
    Optional<Student> findStudentByUsername(@Param("username") String username, @Param("password") String password);

    @Query("SELECT s FROM Student s WHERE s.username = :username")
    Optional<Student> findStudentByTest(@Param("username") String username);


    @Query("SELECT s FROM Student s WHERE s.email = :email AND s.password = :password")
    Optional<Student> findStudentByEmail(@Param("email") String email, @Param("password") String password);

}

