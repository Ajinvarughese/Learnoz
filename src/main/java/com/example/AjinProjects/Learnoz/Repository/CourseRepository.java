package com.example.AjinProjects.Learnoz.Repository;

import com.example.AjinProjects.Learnoz.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {
    @Query("SELECT c FROM Course c WHERE c.id = :id")
    Optional<Course> findVideo(@Param("id") UUID id);

    @Query("SELECT c FROM Course c WHERE c.genre = :genre")
    List<Course> findVideoByGenre(@Param("genre") String genre);

    @Query("SELECT c FROM Course c WHERE c.tutorId = :id")
    List<Course> findVideoByTutor(@Param("id") UUID id);

    @Query("UPDATE Course c SET c.likes = c.likes+1 WHERE c.id = :id")
    void incrementLike(@Param("id") UUID id);

    @Query("UPDATE Course c SET c.likes = c.likes-1 WHERE c.id = :id")
    void decrementLike(@Param("id") UUID id);

    @Query("UPDATE Course c SET c.views = c.views+1 WHERE c.id = :id")
    void addView(@Param("id") UUID id);
}
