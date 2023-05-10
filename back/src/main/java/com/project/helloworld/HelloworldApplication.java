package com.project.helloworld;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaAuditing
<<<<<<< HEAD
=======
@EnableScheduling
@EnableConfigurationProperties(AppProperties.class)
>>>>>>> 16a6c759ae22dde36cd7a5b92919238738b2ad28
public class HelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);

	}
}
