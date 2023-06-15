package com.consulta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class ProyectoConsultorioVersion21Application {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoConsultorioVersion21Application.class);
		System.out.println("Versión De Springframework"+SpringVersion.getVersion());
		
		 
	}

}
