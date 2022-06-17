package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.main.initialize.InitCore;

@SpringBootApplication
public class FredsSpringRpgEngineApplication {
	
	static InitCore init;
	
	@Autowired
	public void setInit(InitCore init) {
		FredsSpringRpgEngineApplication.init = init;
	}

	public static void main(String[] args) {
		SpringApplication.run(FredsSpringRpgEngineApplication.class, args);
		init.initialize();
	}

}
