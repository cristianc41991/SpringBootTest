package com.ejercicio.Ejercicio.controller;

import com.ejercicio.Ejercicio.dto.GenericModelMapper;
import com.ejercicio.Ejercicio.dto.TransaccionDTO;
import com.ejercicio.Ejercicio.entities.Transaccion;
import com.ejercicio.Ejercicio.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transaccion")
public class TransaccionController {

    TransaccionRepository transaccionRepository;
    public TransaccionController(TransaccionRepository transaccionRepository){
        this.transaccionRepository = transaccionRepository;
    }
    @PostMapping("/")
    ResponseEntity<String> crearTransaccion(@RequestBody List<TransaccionDTO> transaccions){
        List<Transaccion> transacciones = transaccions.stream().map(t -> GenericModelMapper.singleInstance().mapToDTOTransaccion(t)).collect(Collectors.toList());
        transaccionRepository.saveAll(transacciones);
        return  new ResponseEntity<String>("Ok", HttpStatus.OK);
    }
    @GetMapping("/{datefrom}/{dateuntil}/{idcuenta}")
    ResponseEntity<List<TransaccionDTO>> obtenerTransaccionesByCuentaByDates(@PathVariable("datefrom") String datefrom, @PathVariable("dateuntil") String dateuntil, @PathVariable("idcuenta") Long idcuenta){
        LocalDate fechaini = LocalDate.parse(datefrom);
        LocalDate fechafin = LocalDate.parse(dateuntil);
        return new ResponseEntity<List<TransaccionDTO>>(transaccionRepository.findByDates(fechaini,fechafin, idcuenta).
                stream().map(t -> GenericModelMapper.singleInstance().mapToTransaccionDTO(t)).collect(Collectors.toList()), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    ResponseEntity<String> eliminarTransaccion(@PathVariable("id") Long id){
        Transaccion transaccion = this.transaccionRepository.findById(id).get();
        this.transaccionRepository.delete(transaccion);
        return new ResponseEntity<String>("Ok", HttpStatus.OK);
    }
}
