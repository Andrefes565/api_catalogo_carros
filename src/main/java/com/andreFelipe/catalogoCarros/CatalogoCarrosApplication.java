package com.andreFelipe.catalogoCarros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com/andreFelipe/catalogoCarros/domains/model")
@SpringBootApplication
public class CatalogoCarrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogoCarrosApplication.class, args);
	}

}
