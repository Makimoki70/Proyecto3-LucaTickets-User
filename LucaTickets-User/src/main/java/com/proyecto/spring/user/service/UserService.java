package com.proyecto.spring.user.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.proyecto.spring.user.model.User;
import com.proyecto.spring.user.repository.DAOUser;

public class UserService {
	
	@Autowired
	private DAOUser daoUser;

	public void addUser(Long id, String nombre, String apellido, String mail, String contrasena, Date fecha_alta) {
			final User user = daoUser.findById(id).orElseThrow();
		
			//Añadir los setters
			User user = new User();
			user.setNombre(nombre);
			user.setApellido(apellido);
			user.setMail(mail);
			user.setContrasena(contrasena);
			user.setDate(fecha_alta);
			daoUser.save(user);
	}
}
