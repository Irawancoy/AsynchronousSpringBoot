package com.example.TalentEvaluation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync //Menambahkan anotasi @EnableAsync untuk mengaktifkan dukungan asinkron
public class TalentEvaluationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalentEvaluationApplication.class, args);
	}

}
