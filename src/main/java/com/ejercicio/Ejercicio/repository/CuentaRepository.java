package com.ejercicio.Ejercicio.repository;

import com.ejercicio.Ejercicio.entities.Cuenta;
import com.ejercicio.Ejercicio.entities.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta,Long> {
    @Query("Select c From Cuenta c Where c.persona.id=:idpersona")
    Collection<Cuenta> findCuentasbyPersona(Long idpersona);
}
