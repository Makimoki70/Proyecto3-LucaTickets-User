package com.proyecto.spring.user;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyecto.spring.user.model.User;
import com.proyecto.spring.user.repository.DAOUser;

@SpringBootTest
public class Test03_DatabaseNoVacia {
	
	@Autowired
	private DAOUser repository;
	
	@Test
	void contextLoads() {
		List<User> users = repository.findAll();
		assertTrue(users.size() > 0);
	}
}
