package com.example.AjinProjects.Learnoz.Repository;

import com.example.AjinProjects.Learnoz.Model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {
    @Query("SELECT s FROM Tutor s WHERE s.username = :username AND s.password = :password")
    Optional<Tutor> findTutorByUsername(@Param("username") String username, @Param("password") String password);

    @Query("SELECT s FROM Tutor s WHERE s.email = :email AND s.password = :password")
    Optional<Tutor> findTutorByEmail(@Param("email") String email, @Param("password") String password);

    @Query("SELECT s FROM Tutor s WHERE s.id = :id AND s.password = :password")
    Optional<Tutor> findTutorById(@Param("id") Long id, @Param("password") String password);
}
