package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.main.initialize.InitCore;

@SpringBootApplication
public class FredsSpringRpgEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(FredsSpringRpgEngineApplication.class, args);
		InitCore.initialize();
	}

}
