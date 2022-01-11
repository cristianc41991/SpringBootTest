package com.ejercicio.Ejercicio;

import com.ejercicio.Ejercicio.controller.PersonaController;
import com.ejercicio.Ejercicio.dto.CuentaDTO;
import com.ejercicio.Ejercicio.dto.GenericModelMapper;
import com.ejercicio.Ejercicio.dto.PersonaDTO;
import com.ejercicio.Ejercicio.dto.TransaccionDTO;
import com.ejercicio.Ejercicio.entities.Cuenta;
import com.ejercicio.Ejercicio.entities.Persona;
import com.ejercicio.Ejercicio.entities.Transaccion;
import com.ejercicio.Ejercicio.repository.CuentaRepository;
import com.ejercicio.Ejercicio.repository.PersonaRepository;
import com.ejercicio.Ejercicio.repository.TransaccionRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.DisplayName.class)
class EjercicioApplicationTests {
	@Autowired
	private PersonaController personaController;

	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private CuentaRepository cuentaRepository;
	@Autowired
	private TransaccionRepository transaccionRepository;



	@Test
	@Order(1)
	void contextLoads() {
		assertThat(personaController).isNotNull();
		assertThat(personaRepository).isNotNull();
		assertThat(cuentaRepository).isNotNull();
		assertThat(transaccionRepository).isNotNull();
	}

	@Test
	@Order(2)
	public void TestCrearPersona()
	{
		PersonaDTO persona = new PersonaDTO();
		persona.setIdentificacion("1205816026");
		persona.setName("Cristian");
		persona.setEmail("cristian.cristianc4@gmail.com");
		persona.setTelefono("0982297448");
		Persona p = GenericModelMapper.singleInstance().mapToDTOPersona(persona);
		personaRepository.save(p);
		assertThat(p.getId()).isNotNull();
	}

	@Test
	@Order(3)
	public void TestActualizarPersona()
	{
		PersonaDTO persona = new PersonaDTO();
		persona.setId(1L);
		persona.setIdentificacion("1205816026");
		persona.setName("Cristian");
		persona.setEmail("cristian.cristianc4@gmail.com");
		persona.setTelefono("0982297448");
		Persona p = GenericModelMapper.singleInstance().mapToDTOPersona(persona);
		personaRepository.save(p);
		assertThat(p.getId()).isNotNull();
	}
	@Test
	@Order(4)
	public void TestCrearCuenta()
	{
		CuentaDTO cuentaDTO = new CuentaDTO();
		cuentaDTO.setIdpersona(1L);
		cuentaDTO.setNumero("2255445566");

		Cuenta c = GenericModelMapper.singleInstance().mapToDTOCuenta(cuentaDTO);
		Persona p = new Persona();
		p.setId(cuentaDTO.getIdpersona());
		c.setPersona(p);
		cuentaRepository.save(c);
		assertThat(c.getId()).isNotNull();
	}

	@Test
	@Order(5)
	public void TestCrearTransaccion(){
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		transaccionDTO.setFecha(LocalDate.parse("2022-01-10"));
		transaccionDTO.setIdcuenta(1L);
		transaccionDTO.setMonto(12.5);
		Transaccion t = GenericModelMapper.singleInstance().mapToDTOTransaccion(transaccionDTO);
		transaccionRepository.save(t);
		assertThat(t.getId()).isNotNull();
	}


}
