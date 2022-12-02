package com.proyecto.spring.user.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

import com.proyecto.spring.user.model.User;
import com.proyecto.spring.user.repository.DAOUser;

@Service
public class UserService {

	@Autowired
	private DAOUser daoUser;

	public User addUser(Long id, String nombre, String apellido, String mail, String contrasena, Date fecha_alta) {
		final User user = daoUser.findById(id).orElseThrow();

		daoUser.save(user);
		
		return user;
	}
}
