package com.example.AjinProjects.Learnoz.Controller;

import com.example.AjinProjects.Learnoz.Model.Tutor;
import com.example.AjinProjects.Learnoz.Service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<Tutor> findTutor(@RequestBody Tutor tutor, @PathVariable String username) {
        return service.findTutor(tutor, username);
    }

    @PostMapping("/signup")
    public void newStudent(@RequestBody Tutor tutor) {
        service.newTutor(tutor);
    }

    @PostMapping("/login")
    public void loginStudent(@RequestBody Tutor tutor) {
        service.loginTutor(tutor);
    }
}
