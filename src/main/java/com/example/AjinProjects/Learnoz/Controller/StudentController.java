package com.example.AjinProjects.Learnoz.Controller;

import com.example.AjinProjects.Learnoz.Library.EnrolledStudents;
import com.example.AjinProjects.Learnoz.Model.Student;
import com.example.AjinProjects.Learnoz.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("api/eLearning/student")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }
    @GetMapping("/awi")
    public String show() {
        return "Hello World";
    }
    @PostMapping("/{username}")
    public Optional<Student> studentProfile(@PathVariable String username, @RequestBody String password) {
        return service.findStudent(username, password);
    }

    @PostMapping("/enroll")
    public void enrollCourse(@RequestBody EnrolledStudents enrolledStudents) {
        service.enrollCourse(enrolledStudents);
    }

    @PostMapping("/removeEnrollment")
    public void removeEnrollment(@RequestBody EnrolledStudents enrolledStudents) {
        service.removeEnrollment(enrolledStudents.getStudentId(), enrolledStudents.getCourseId());
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








