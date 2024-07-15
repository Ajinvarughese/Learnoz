package com.example.AjinProjects.Learnoz.Service;


import com.example.AjinProjects.Learnoz.Library.DateTime;
import com.example.AjinProjects.Learnoz.Model.Tutor;
import com.example.AjinProjects.Learnoz.Repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TutorService {
    private final TutorRepository repository;

    @Autowired
    public TutorService(TutorRepository repository) {
        this.repository = repository;
    }

    public void newTutor(Tutor tutor) {
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
        repository.save(newTutor);
    }

    public Optional<Tutor> findTutor(String username, String password) {
        return repository.findTutorByUsername(username, password);
    }

    public void loginTutor(Tutor tutor) {
        String email = tutor.getEmail();
        String username = tutor.getUsername();
        String password = tutor.getPassword();

        if(!username.isEmpty()) {
            Optional<Tutor> tutorUsername = repository.findTutorByUsername(username, password);
            if(tutorUsername.isEmpty()) {
                throw new IllegalStateException("User not found!");
            }
        }else if(!email.isEmpty()) {
            Optional<Tutor> tutorEmail = repository.findTutorByEmail(email, password);
            if(tutorEmail.isEmpty()) {
                throw new IllegalStateException("User not found!");
            }
        }else {
            throw new IllegalStateException("Bad json request!");
        }
    }
}
