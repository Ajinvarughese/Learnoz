package com.example.AjinProjects.Learnoz.Controller;

import com.example.AjinProjects.Learnoz.Model.Course;
import com.example.AjinProjects.Learnoz.Service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/eLearning/course")
public class CourseController {
    private CourseService service;

    @GetMapping("/{course_id}")
    public Optional<Course> showCourse(@PathVariable Long id) {
        return service.findCourses(id);
    }
}
