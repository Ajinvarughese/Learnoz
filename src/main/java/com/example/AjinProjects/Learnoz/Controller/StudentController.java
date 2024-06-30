package com.example.AjinProjects.Learnoz.Controller;

import com.example.AjinProjects.Learnoz.Model.Student;
import com.example.AjinProjects.Learnoz.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/eLearning/Student")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/{username}")
    public Optional<Student> findStudent(@PathVariable String username, @PathVariable String password) {
        return service.findStudent(username, password);
    }

    @PostMapping("/signup")
    public void newStudent(@RequestBody Student student) {
        service.newStudent(student);
    }

    @PostMapping("/login")
    public void loginStudent(@RequestBody Student student) {
        service.loginStudent(student);
    }
}








