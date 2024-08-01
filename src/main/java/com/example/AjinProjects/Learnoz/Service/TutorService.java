package com.example.AjinProjects.Learnoz.Service;


import com.example.AjinProjects.Learnoz.Library.DateTime;
import com.example.AjinProjects.Learnoz.Model.Tutor;
import com.example.AjinProjects.Learnoz.Repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TutorService {
    private final TutorRepository repository;

    @Autowired
    public TutorService(TutorRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<String> newTutor(Tutor tutor) {
        Tutor newTutor = new Tutor(
                tutor.getFirstName(),
                tutor.getSureName(),
                tutor.getEmail(),
                tutor.getPassword(),
                tutor.getUsername(),
                DateTime.currentDateTime(),
                tutor.getDob(),
                tutor.getGender(),
                false
        );

        Optional<Tutor> checkExistence = repository.findTutorByEmailOnly(tutor.getEmail());
        if(checkExistence.isPresent()) {
            return new ResponseEntity<>("Email already exists", HttpStatus.CONFLICT);
        }else {
            repository.save(newTutor);
            return new ResponseEntity<>("Student created successfully", HttpStatus.OK);
        }
    }

    public Optional<Tutor> findTutor(String username, String password) {
        return repository.findTutorByUsername(username, password);
    }

    public ResponseEntity<String> loginTutor(Tutor tutor) {
        String email = tutor.getEmail();
        String username = tutor.getUsername();
        String password = tutor.getPassword();

        if(!username.isEmpty()) {
            Optional<Tutor> tutorUsername = repository.findTutorByUsername(username, password);
            if(tutorUsername.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
            }

        }else if(!email.isEmpty()) {
            Optional<Tutor> tutorEmail = repository.findTutorByEmail(email, password);
            if(tutorEmail.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
            }
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad JSON");
        }
        return ResponseEntity.ok("Login successful");
    }
}
