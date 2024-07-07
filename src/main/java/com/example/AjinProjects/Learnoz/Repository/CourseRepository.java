package com.example.AjinProjects.Learnoz.Repository;

import com.example.AjinProjects.Learnoz.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT s FROM Course s WHERE s.id = :id")
    Optional<Course> findVideo(@Param("id") Long id);

    @Query("SELECT s FROM Course s WHERE s.genre = :genre")
    List<Course> findVideoByGenre(@Param("genre") String genre);

    @Query("SELECT s FROM Course s WHERE s.tutorId = :id")
    List<Course> findVideoByTutor(@Param("id") Long id);
}
