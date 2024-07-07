package com.example.AjinProjects.Learnoz.Controller;

import com.example.AjinProjects.Learnoz.Model.Course;
import com.example.AjinProjects.Learnoz.Service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/eLearning/course")
public class CourseController {
    private CourseService service;

    @GetMapping("/{courseId}")
    public Optional<Course> showCourse(@PathVariable Long id) {
        return service.showCourse(id);
    }

    @GetMapping("/genre/{genre}")
    public List<Course> showCourseByGenre(@PathVariable String genre) {
        return service.showCourseByGenre(genre);
    }

    @GetMapping("/tutor/{tutorId}")
    public List<Course> showCourseByTutor(@PathVariable Long id) {
        return service.showCourseByTutor(id);
    }

    @PostMapping("/newCourse")
    public void newCourse(Course course) {
        service.newCourse(course);
    }

    @PostMapping("/updateCourse")
    public void updateCourse(Course course) {
        service.updateCourse(course);
    }

    @DeleteMapping("/deleteCourse")
    public void deleteCourse(Course course) {
        service.deleteCourse(course);
    }
}
