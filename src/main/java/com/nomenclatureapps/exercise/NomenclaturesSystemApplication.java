package com.nomenclatureapps.exercise;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.nomenclatureapps.exercise.service.NomencaltureService;
import com.nomenclatureapps.exercise.utils.ReadExcelFile;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableWebMvc
public class NomenclaturesSystemApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		
		
		ConfigurableApplicationContext context = SpringApplication.run(NomenclaturesSystemApplication.class, args);
		
		NomencaltureService nomencaltureService =  context.getBean(NomencaltureService.class);
		try {
			
			File resource = new ClassPathResource("Nomencaltural.xlsx").getFile();
			nomencaltureService.putNaceDetails(ReadExcelFile.readExcellSheet(resource.getPath(), 0));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
