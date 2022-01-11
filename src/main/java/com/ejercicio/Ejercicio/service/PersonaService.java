package com.ejercicio.Ejercicio.service;

import com.ejercicio.Ejercicio.entities.Persona;
import java.util.List;
public interface PersonaService {
    Persona getPersonaById(Long id);
    List<Persona> ListPersona();
    void save(Persona persona);
}
