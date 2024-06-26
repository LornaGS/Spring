package com.qa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class LbgSpring2Application {

	public static void main(String[] args) {
		SpringApplication.run(LbgSpring2Application.class, args);
	}



}
