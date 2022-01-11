package com.ejercicio.Ejercicio.dto;

import com.ejercicio.Ejercicio.entities.Cuenta;
import com.ejercicio.Ejercicio.entities.Persona;
import com.ejercicio.Ejercicio.entities.Transaccion;
import org.modelmapper.ModelMapper;

public class GenericModelMapper {
    private final ModelMapper mapper = new ModelMapper();
    private static GenericModelMapper instance;
    private GenericModelMapper(){

    }
    public PersonaDTO mapToPersonaDTO(Persona persona){
        return mapper.map(persona,PersonaDTO.class);
    }
    public Persona mapToDTOPersona(PersonaDTO personaDTO){
        return mapper.map(personaDTO,Persona.class);
    }
    public CuentaDTO mapToCuentaDTO(Cuenta cuenta){
        CuentaDTO cuentaDTO =mapper.map(cuenta,CuentaDTO.class);
        cuentaDTO.setIdpersona(cuenta.getPersona().getId());
        return cuentaDTO;
    }
    public Cuenta mapToDTOCuenta(CuentaDTO cuentaDTO){
        Cuenta cuenta = mapper.map(cuentaDTO,Cuenta.class);
        Persona p = new Persona();
        p.setId(cuentaDTO.getIdpersona());
        cuenta.setPersona(p);
        return cuenta;
    }
    public TransaccionDTO mapToTransaccionDTO(Transaccion transaccion){
        TransaccionDTO transaccionDTO = mapper.map(transaccion,TransaccionDTO.class);

        transaccionDTO.setIdcuenta(transaccion.getId());
        return transaccionDTO;
    }
    public Transaccion mapToDTOTransaccion(TransaccionDTO transaccionDTO){
        Transaccion transaccion = mapper.map(transaccionDTO,Transaccion.class);
        Cuenta c = new Cuenta();

        c.setId(transaccionDTO.getIdcuenta());
        transaccion.setCuenta(c);
        return transaccion;
    }


    public static GenericModelMapper singleInstance(){
        if(instance == null) {
            instance = new GenericModelMapper();
        }
        return instance;
    }
}
