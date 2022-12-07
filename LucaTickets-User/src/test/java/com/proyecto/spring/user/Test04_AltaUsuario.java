package com.proyecto.spring.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyecto.spring.user.model.User;
import com.proyecto.spring.user.repository.DAOUser;

@SpringBootTest
public class Test04_AltaUsuario {
	
	@Autowired
	DAOUser daoUser;
	
	
	@Test
	void contextLoads() {
		User user = new User();
		
		LocalDate myDate = LocalDate.parse("01-12-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		
		user.setId(-1L);
		user.setNombre("Prueba");
		user.setApellido("BaseDatos");
		user.setMail("PruebasIngreso@hotmail.com");
		user.setPass("123");
		user.setFecha_alta(Date.valueOf(myDate));
		
		User userSaved = daoUser.save(user);
		
		assertThat(userSaved.getId()).isNotEqualTo(-1L);
		//assertThat(daoUser.findById(userSaved.getId()).get().getNombre()).contains("Prueba");
	}
}