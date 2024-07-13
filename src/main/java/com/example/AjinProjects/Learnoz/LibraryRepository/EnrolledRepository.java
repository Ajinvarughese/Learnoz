package com.example.AjinProjects.Learnoz.LibraryRepository;

import com.example.AjinProjects.Learnoz.Library.EnrolledStudents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EnrolledRepository extends JpaRepository<EnrolledStudents, Long> {

}
