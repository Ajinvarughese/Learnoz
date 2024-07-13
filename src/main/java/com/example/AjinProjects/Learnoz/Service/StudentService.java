package com.example.AjinProjects.Learnoz.Service;

import com.example.AjinProjects.Learnoz.Library.EnrolledStudents;
import com.example.AjinProjects.Learnoz.LibraryRepository.EnrolledRepository;
import com.example.AjinProjects.Learnoz.Model.Student;
import com.example.AjinProjects.Learnoz.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final EnrolledRepository enrolledRepository;

    @Autowired
    public StudentService(StudentRepository repository, EnrolledRepository enrolledRepository) {
        this.repository = repository;
        this.enrolledRepository = enrolledRepository;
    }

    public Optional<Student> findStudent(String username, String password) {
        return repository.findStudentByUsername(username, password);
    }

    public void newStudent(Student student) {
        repository.save(student);
    }

    public void loginStudent(Student student) {
        String email = student.getEmail();
        String username = student.getUsername();
        String password = student.getPassword();

        if(!username.isEmpty()) {
            Optional<Student> studentUsername = repository.findStudentByUsername(username, password);
            if(studentUsername.isEmpty()) {
                throw new IllegalStateException("User not found!");
            }
        }else if(!email.isEmpty()) {
            Optional<Student> studentEmail = repository.findStudentByEmail(email, password);
            if(studentEmail.isEmpty()) {
                throw new IllegalStateException("User not found!");
            }
        }else {
            throw new IllegalStateException("Bad json request!");
        }
    }

    public void enrollCourse(EnrolledStudents enrolledStudents) {
        enrolledRepository.save(enrolledStudents);
    }
}
