package com.proyecto.spring.user.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.proyecto.spring.user.model.User;
import com.proyecto.spring.user.repository.DAOUser;

@Service
public class UserService {

	@Autowired
	private DAOUser daoUser;
	
	public User addUser(User user) {
		//final User user = daoUser.findById(id).orElseThrow();
		
		return daoUser.save(user);
	}
}