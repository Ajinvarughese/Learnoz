package com.example.AjinProjects.Learnoz.Service;

import com.example.AjinProjects.Learnoz.Library.DateTime;
import com.example.AjinProjects.Learnoz.Library.Likes;
import com.example.AjinProjects.Learnoz.LibraryRepository.LikesRepository;
import com.example.AjinProjects.Learnoz.Model.Course;
import com.example.AjinProjects.Learnoz.Model.Student;
import com.example.AjinProjects.Learnoz.Model.Tutor;
import com.example.AjinProjects.Learnoz.Repository.CourseRepository;
import com.example.AjinProjects.Learnoz.Repository.StudentRepository;
import com.example.AjinProjects.Learnoz.Repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseService {

    private final CourseRepository repository;
    private final LikesRepository likesRepository;
    private static TutorRepository tutorRepository;
    private static StudentRepository studentRepository;

    @Autowired
    public CourseService(CourseRepository repository, LikesRepository likesRepository) {
        this.repository = repository;
        this.likesRepository = likesRepository;
    }

    public Optional<Course> showCourse(UUID id) {
        return repository.findVideo(id);
    }

    public List<Course> showCourseByGenre(String genre) {
        return repository.findVideoByGenre(genre);
    }

    public List<Course> showCourseByTutor(UUID id) {
        return repository.findVideoByTutor(id);
    }

    public void newCourse(Course course) {
         Course newCourse = new Course(
                 course.getUrl(),
                 0,
                 0,
                 course.getId(),
                 course.getTutorId(),
                 course.getPassword(),
                 course.getGenre(),
                 course.getDifficulty(),
                 course.getDescription(),
                 DateTime.currentDateTime()
         );
         repository.save(newCourse);
    }

    public void updateCourse(Course course) {
        if(tutorAuthentication(course.getId(), course.getPassword())) {
            repository.save(course);
        }else {
            throw new IllegalStateException("Authentication failed!");
        }
    }

    public void deleteCourse(Course course) {
        if(tutorAuthentication(course.getId(), course.getPassword())) {
            repository.deleteById(course.getId());
        }else {
            throw new IllegalStateException("Authentication failed!");
        }
    }

    public void likeVideo(UUID courseId,UUID userId, String password,String userType) {
        switch (userType) {
            case "student":
                if(studentAuthentication(userId, password)) {
                    repository.incrementLike(courseId);
                    Likes likes = new Likes(courseId, userId, "", userType, DateTime.currentDateTime());
                    try {
                        likesRepository.save(likes);
                    }catch (IllegalStateException e) {
                        throw new IllegalStateException("Course not found ERROR: \n\n"+e.getMessage());
                    }
                }
                break;
            case "tutor":
                if(tutorAuthentication(userId, password)) {
                    repository.incrementLike(courseId);
                    Likes likes = new Likes(courseId, userId, userType, "", DateTime.currentDateTime());
                    try {
                        likesRepository.save(likes);
                    }catch (IllegalStateException e) {
                        throw new IllegalStateException("Course not found ERROR: \n\n"+e.getMessage());
                    }
                }
                break;
            default:
                throw new IllegalStateException("Wrong user type!");
        }
    }

    public void removeLike(UUID courseId, UUID userId, String password,String userType) {
        switch (userType) {
            case "student":
                if(studentAuthentication(userId, password)) {
                    repository.decrementLike(courseId);
                    try {
                        likesRepository.removeLikeByUserId(userId);
                    }catch (IllegalStateException e) {
                        throw new IllegalStateException("Course not found ERROR: \n\n"+e.getMessage());
                    }
                }
                break;
            case "tutor":
                if(tutorAuthentication(userId, password)) {
                    repository.decrementLike(courseId);
                    try {
                        likesRepository.removeLikeByUserId(userId);
                    }catch (IllegalStateException e) {
                        throw new IllegalStateException("Course not found ERROR: \n\n"+e.getMessage());
                    }
                }
                break;
            default:
                throw new IllegalStateException("Wrong user type!");
        }
    }

    public void addView(UUID courseId) {
        repository.addView(courseId);
    }

    public static Boolean tutorAuthentication(UUID id, String password) {
        Optional<Tutor> findUser = tutorRepository.findTutorById(id, password);
        return findUser.isPresent();
    }

    public static Boolean studentAuthentication(UUID id, String password) {
        Optional<Student> findUser = studentRepository.findStudentById(id, password);
        return findUser.isPresent();
    }


}
