package com.proyecto.spring.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.proyecto.spring.user.model.User;

@SpringBootTest
public class Test01_ConexionBaseDatos {

	// Lo usaremos para llamar al servicio REST
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
		assertThat(restTemplate.getForObject("http://localhost:8888/user/{id}", User.class, 1).getNombre())
				.contains("Prueba");
	}
}
