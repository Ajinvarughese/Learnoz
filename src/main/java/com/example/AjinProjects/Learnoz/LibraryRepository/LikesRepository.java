package com.example.AjinProjects.Learnoz.LibraryRepository;

import com.example.AjinProjects.Learnoz.Library.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {
    @Query("DELETE FROM Likes l WHERE l.userId = :id")
    void removeLikeByUserId(@Param("id") UUID id);
}
