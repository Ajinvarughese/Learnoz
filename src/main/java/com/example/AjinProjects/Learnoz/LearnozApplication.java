package com.example.AjinProjects.Learnoz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "https://localhost:5173")
public class LearnozApplication {
	public static void main(String[] args) {
		SpringApplication.run(LearnozApplication.class, args);
	}

}
