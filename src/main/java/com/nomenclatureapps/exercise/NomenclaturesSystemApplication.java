package com.nomenclatureapps.exercise;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import com.nomenclatureapps.exercise.service.NomencaltureService;

@SpringBootApplication
public class NomenclaturesSystemApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		
		
		ConfigurableApplicationContext context = SpringApplication.run(NomenclaturesSystemApplication.class, args);
		
		NomencaltureService nomencaltureService =  context.getBean(NomencaltureService.class);
		nomencaltureService.putNaceDetails(new ArrayList());
	}

}
