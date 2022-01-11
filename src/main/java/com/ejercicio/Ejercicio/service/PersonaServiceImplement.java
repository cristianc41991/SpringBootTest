package com.ejercicio.Ejercicio.service;

import com.ejercicio.Ejercicio.entities.Persona;
import com.ejercicio.Ejercicio.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonaServiceImplement implements  PersonaService{
    PersonaRepository personaRepository;

    public PersonaServiceImplement(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }
    @Override
    public Persona getPersonaById(Long id) {
       return personaRepository.getById(id);
    }

    @Override
    public List<Persona> ListPersona() {
        return personaRepository.findAll();
    }

    @Override
    public void save(Persona persona) {
        personaRepository.save(persona);
    }
}
