package com.ejercicio.Ejercicio.repository;

import com.ejercicio.Ejercicio.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {
}
