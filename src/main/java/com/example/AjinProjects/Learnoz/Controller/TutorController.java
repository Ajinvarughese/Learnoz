package com.example.AjinProjects.Learnoz.Controller;

import com.example.AjinProjects.Learnoz.Model.Tutor;
import com.example.AjinProjects.Learnoz.Service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/eLearning/tutor")
public class TutorController {
    private final TutorService service;
    @Autowired
    public TutorController(TutorService service) {
        this.service = service;
    }
    @GetMapping("/{username}")
    public Optional<Tutor> tutorProfile(@PathVariable String username, @RequestBody String password) {
        return service.findTutor(username, password);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> newStudent(@RequestBody Tutor tutor) {
        return service.newTutor(tutor);
    }

    @PostMapping("/login")
    public void loginStudent(@RequestBody Tutor tutor) {
        service.loginTutor(tutor);
    }

}
