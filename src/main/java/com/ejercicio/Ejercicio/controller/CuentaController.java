package com.ejercicio.Ejercicio.controller;

import com.ejercicio.Ejercicio.dto.CuentaDTO;
import com.ejercicio.Ejercicio.dto.GenericModelMapper;
import com.ejercicio.Ejercicio.entities.Cuenta;
import com.ejercicio.Ejercicio.repository.CuentaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {
    CuentaRepository cuentaRepository;
    public CuentaController(CuentaRepository cuentaRepository){
        this.cuentaRepository = cuentaRepository;
    }
    @GetMapping("/")
    List<CuentaDTO> getAll(){
        return
                this.cuentaRepository.findAll().stream().map(c -> GenericModelMapper.singleInstance().mapToCuentaDTO(c))
                        .collect(Collectors.toList());

    }
    @GetMapping("/{idpersona}")
    List<CuentaDTO> obtenerCuentasPersona(@PathVariable("idpersona") Long idpersona){
        return this.cuentaRepository.findCuentasbyPersona(idpersona).stream()
                .map(c -> GenericModelMapper.singleInstance().mapToCuentaDTO(c))
                .collect(Collectors.toList());
    }
    @PostMapping("/")
    ResponseEntity<CuentaDTO> crearCuenta(@RequestBody CuentaDTO cuenta){
        Cuenta cuentares = GenericModelMapper.singleInstance().mapToDTOCuenta(cuenta);
        this.cuentaRepository.save(cuentares);
        return new ResponseEntity<>(cuenta, HttpStatus.CREATED);
    }

    @PutMapping("/")
    ResponseEntity<CuentaDTO> actualizarCuenta(@RequestBody CuentaDTO cuentaDTO){
        Cuenta cuentares = GenericModelMapper.singleInstance().mapToDTOCuenta(cuentaDTO);
        this.cuentaRepository.save(cuentares);
        return new ResponseEntity<>(cuentaDTO, HttpStatus.OK);
    }
}
