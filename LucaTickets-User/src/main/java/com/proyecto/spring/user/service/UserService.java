package com.proyecto.spring.user.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.proyecto.spring.user.model.User;
import com.proyecto.spring.user.repository.DAOUser;

/**
 * 
 * Nombre de clase: UserService
 * Descripcion: Clase de la capa service, añade el metodo addUser, el cual guarda el usuario actual dentro de la base de datos
 * Fecha: 05/12/2022
 * @author David Gomez Arellano
 * @version 0.1
 * @since 0.1
 * 
 * */

@Service
public class UserService {

	@Autowired
	private DAOUser daoUser;
	
	/**
     * Método puente con DAOUser que pasa los datos de User a la capa repository
     * @return el objeto entity guardado (.save) en el repository
     */
	public User addUser(User user) {
		return daoUser.save(user);
	}
}