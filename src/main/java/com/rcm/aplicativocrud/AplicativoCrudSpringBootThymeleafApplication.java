package com.rcm.aplicativocrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.rcm.models"})//para scaner esse pacote e criar todas as tabelas
public class AplicativoCrudSpringBootThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicativoCrudSpringBootThymeleafApplication.class, args);
		
	}

}
