package com.j5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class J5Demo2Application {
	public static void main(String[] args) {
		SpringApplication.run(J5Demo2Application.class, args);
	}
}
