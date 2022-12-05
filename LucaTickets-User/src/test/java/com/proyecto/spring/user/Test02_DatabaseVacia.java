package com.proyecto.spring.user;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyecto.spring.user.model.User;
import com.proyecto.spring.user.repository.DAOUser;

@SpringBootTest
public class Test02_DatabaseVacia {
	
	@Autowired
	private DAOUser repository;
	
	@Test
	void contextLoads() {
		List<User> users = repository.findAll();
		assertFalse(users.size() == 0);
	}
}