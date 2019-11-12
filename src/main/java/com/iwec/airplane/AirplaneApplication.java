package com.iwec.airplane;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirplaneApplication {
	
	@Autowired
	private App app;

	public static void main(String[] args) {
		SpringApplication.run(AirplaneApplication.class, args);
	}
	
	@PostConstruct
	public void start() {
		app.run();
	}

}
