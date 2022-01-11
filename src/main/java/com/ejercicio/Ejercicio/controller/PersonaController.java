package com.ejercicio.Ejercicio.controller;

import com.ejercicio.Ejercicio.dto.GenericModelMapper;
import com.ejercicio.Ejercicio.dto.PersonaDTO;
import com.ejercicio.Ejercicio.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {
    private PersonaService personaService;
    public PersonaController(PersonaService personaService){
        this.personaService = personaService;
    }

    @GetMapping("/")
    public List<PersonaDTO> getPersonas(){
        return this.personaService.ListPersona().stream().map(p -> GenericModelMapper.singleInstance().mapToPersonaDTO(p))
                        .collect(Collectors.toList());
    }
    @PostMapping("/")
    public ResponseEntity<PersonaDTO> crearPersona(@RequestBody PersonaDTO persona){
        this.personaService.save(GenericModelMapper.singleInstance().mapToDTOPersona(persona));
        return new ResponseEntity<>(persona,HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<PersonaDTO> actualizarPersona(@RequestBody PersonaDTO persona){
        this.personaService.save(GenericModelMapper.singleInstance().mapToDTOPersona(persona));
        return new ResponseEntity<>(persona,HttpStatus.OK);
    }
}
