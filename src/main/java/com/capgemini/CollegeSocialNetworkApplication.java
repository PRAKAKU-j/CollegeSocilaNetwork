package com.capgemini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableJpaRepositories("com.capgemini.repo")
@ComponentScan({"com.capgemini.*"})
public class CollegeSocialNetworkApplication {

	public static void main(String[] args) {

		SpringApplication.run(CollegeSocialNetworkApplication.class, args);
	}

}
