package com.ejercicio.Ejercicio.repository;

import com.ejercicio.Ejercicio.entities.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;


@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion,Long> {
    @Query("SELECT t FROM Transaccion t Where t.fecha >= :datefrom and t.fecha <= :dateuntil and t.cuenta.id = :idcuenta")
    Collection<Transaccion> findByDates(LocalDate datefrom, LocalDate dateuntil, Long idcuenta);
}
