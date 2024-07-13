package com.example.AjinProjects.Learnoz.Controller;

import com.example.AjinProjects.Learnoz.Library.Likes;
import com.example.AjinProjects.Learnoz.Model.Course;
import com.example.AjinProjects.Learnoz.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/eLearning/course")
public class CourseController {
    private final CourseService service;

    @Autowired
    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping("/{courseId}")
    public Optional<Course> showCourse(@PathVariable UUID courseId) {
        service.addView(courseId);
        return service.showCourse(courseId);
    }

    @GetMapping("/genre/{genre}")
    public List<Course> showCourseByGenre(@PathVariable String genre) {
        return service.showCourseByGenre(genre);
    }

    @GetMapping("/tutor/{tutorId}")
    public List<Course> showCourseByTutor(@PathVariable UUID tutorId) {
        return service.showCourseByTutor(tutorId);
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

    @PostMapping("/video/like")
    public void likeVideo(@RequestBody Likes likes) {
        service.likeVideo(likes.getCourseId(), likes.getUserId(), likes.getPassword(), likes.getUserType());
    }
    @DeleteMapping("/video/dislike")
    public void dislikeVideo(@RequestBody Likes likes) {
        service.removeLike(likes.getCourseId(), likes.getUserId(), likes.getPassword(), likes.getUserType());
    }
    /*
        TODO:
            - Create entity and methods for comments
    */
}
