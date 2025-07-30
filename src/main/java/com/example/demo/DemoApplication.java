package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import entities.Dueno;
import repository.IDuenoRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	@Autowired
	private IDuenoRepository duenoRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		duenoRepository.save(new Dueno("Pedro", "333", "Cll","pggv", "pggv1"));

		List<Dueno> listaDueno = duenoRepository.findAll();

		listaDueno.forEach(d -> System.out.println("Dueño: "+d.getNombre()));
		
		
	}

}
