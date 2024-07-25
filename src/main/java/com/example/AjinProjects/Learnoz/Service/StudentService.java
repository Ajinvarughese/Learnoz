package com.example.AjinProjects.Learnoz.Service;

import com.example.AjinProjects.Learnoz.Library.DateTime;
import com.example.AjinProjects.Learnoz.Library.EnrolledStudents;
import com.example.AjinProjects.Learnoz.LibraryRepository.EnrolledRepository;
import com.example.AjinProjects.Learnoz.Model.Student;
import com.example.AjinProjects.Learnoz.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<String> newStudent(Student student) {
        Student newStudent = new Student(
                student.getFirstName(),
                student.getSureName(),
                student.getEmail(),
                student.getPassword(),
                student.getUsername(),
                DateTime.currentDateTime(),
                student.getDob(),
                student.getGender(),
                false
        );
        Optional<Student> checkExistence = repository.findStudentByEmailOnly(student.getEmail());
        if(checkExistence.isPresent()) {
            return new ResponseEntity<>("Email already exists", HttpStatus.CONFLICT);
        }else {
            repository.save(newStudent);
            return new ResponseEntity<>("Student created successfully", HttpStatus.OK);
        }
    }

    public void loginStudent(Student student) {
        Student loginStudent = new Student(student.getEmail(), student.getUsername(), student.getPassword());
        String email = loginStudent.getEmail();
        String username = loginStudent.getUsername();
        String password = loginStudent.getPassword();

        if(!username.isEmpty()) {
            Optional<Student> studentUsername = repository.findStudentByUsername(username, password);
            if(studentUsername.isEmpty()) {
                throw new IllegalStateException("username or password must be wrong!");
            }
        }else if(!email.isEmpty()) {
            Optional<Student> studentEmail = repository.findStudentByEmail(email, password);
            if(studentEmail.isEmpty()) {
                throw new IllegalStateException("username or password must be wrong!");
            }
        }else {
            throw new IllegalStateException("Bad json request!");
        }
    }

    public void enrollCourse(EnrolledStudents enrolledStudents) {
        enrolledRepository.save(enrolledStudents);
    }
    public void removeEnrollment(UUID studentId, UUID courseId) {
        enrolledRepository.removeEnrollment(studentId, courseId);
    }
}
