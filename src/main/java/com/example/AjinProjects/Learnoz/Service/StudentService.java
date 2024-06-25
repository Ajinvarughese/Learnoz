package com.example.AjinProjects.Learnoz.Service;

import com.example.AjinProjects.Learnoz.Model.Student;
import com.example.AjinProjects.Learnoz.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
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
            Optional<Student> myUsername = repository.findStudentByUsername(username, password);
            if(myUsername.isEmpty()) {
                throw new IllegalStateException("User not found!");
            }
        }else if(!email.isEmpty()) {
            Optional<Student> myEmail = repository.findStudentByEmail(email, password);
            if(myEmail.isEmpty()) {
                throw new IllegalStateException("User not found!");
            }
        }else {
            throw new IllegalStateException("Bad json request!");
        }
    }
}
