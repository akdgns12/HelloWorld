package com.project.StoryModule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StoryModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoryModuleApplication.class, args);
	}

}
