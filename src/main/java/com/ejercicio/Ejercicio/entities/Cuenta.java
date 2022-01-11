package com.ejercicio.Ejercicio.entities;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cuenta")
@DynamicUpdate
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String numero;


    @ManyToOne(targetEntity = Persona.class)
    private Persona persona;

    @OneToMany(mappedBy = "cuenta",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    List<Transaccion> transaccionList;

    public Cuenta() {
        persona = new Persona();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Transaccion> getTransaccionList() {
        return transaccionList;
    }

    public void setTransaccionList(List<Transaccion> transaccionList) {
        this.transaccionList = transaccionList;
    }


}
