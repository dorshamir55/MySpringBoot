package com.example.MySpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

//@EnableAutoConfiguration("com.example.MySpringBoot")
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.example.MySpringBoot")
@EnableJpaRepositories("com.example.MySpringBoot.repository")
public class MySpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootApplication.class, args);
	}

}
