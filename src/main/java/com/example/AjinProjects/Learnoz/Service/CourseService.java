package com.example.AjinProjects.Learnoz.Service;

import com.example.AjinProjects.Learnoz.Model.Course;
import com.example.AjinProjects.Learnoz.Model.Tutor;
import com.example.AjinProjects.Learnoz.Repository.CourseRepository;
import com.example.AjinProjects.Learnoz.Repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository repository;
    private static TutorRepository tutorRepository;
    @Autowired
    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public Optional<Course> showCourse(Long id) {
        return repository.findVideo(id);
    }

    public List<Course> showCourseByGenre(String genre) {
        return repository.findVideoByGenre(genre);
    }

    public List<Course> showCourseByTutor(Long id) {
        return repository.findVideoByTutor(id);
    }

    public void newCourse(Course course) {
        ZonedDateTime dateTimeInIST = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        String dateTime = dateTimeInIST.format(formatter);
         Course newCourse = new Course(
                 course.getUrl(),
                 0,
                 course.getRating(),
                 course.getId(),
                 course.getTutorId(),
                 course.getPassword(),
                 course.getGenre(),
                 course.getDifficulty(),
                 course.getDescription(),
                 dateTime
         );
         repository.save(newCourse);
    }

    public void updateCourse(Course course) {
        if(authentication(course.getId(), course.getPassword())) {
            repository.save(course);
        }else {
            throw new IllegalStateException("Authentication failed!");
        }
    }

    public void deleteCourse(Course course) {
        if(authentication(course.getId(), course.getPassword())) {
            repository.deleteById(course.getId());
        }else {
            throw new IllegalStateException("Authentication failed!");
        }
    }

    public static Boolean authentication(Long id, String password) {
        Optional<Tutor> findUser = tutorRepository.findTutorById(id, password);
        return findUser.isPresent();
    }
}
