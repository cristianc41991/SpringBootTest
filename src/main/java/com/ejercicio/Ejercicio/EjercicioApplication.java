package com.ejercicio.Ejercicio;


import com.ejercicio.Ejercicio.repository.PersonaRepository;
import com.ejercicio.Ejercicio.repository.TransaccionRepository;
import com.ejercicio.Ejercicio.service.PersonaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EjercicioApplication implements CommandLineRunner {

	PersonaRepository personaRepository;
	TransaccionRepository transaccionRepository;
	PersonaService personaService;
	public  EjercicioApplication(PersonaRepository personaRepository, TransaccionRepository transaccionRepository,PersonaService personaService){
		this.personaRepository = personaRepository;
		this.transaccionRepository = transaccionRepository;
		this.personaService = personaService;
	}
	public static void main(String[] args) {
		SpringApplication.run(EjercicioApplication.class, args);
	}

	@Override
	public void run(String... args) {

	}
}
