package com.shuz.shuzProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ShuzProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShuzProjectApplication.class, args);
	}

}
