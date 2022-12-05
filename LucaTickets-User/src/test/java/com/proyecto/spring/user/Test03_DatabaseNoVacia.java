package com.proyecto.spring.user;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.proyecto.spring.user.model.User;

@SpringBootTest
public class Test03_DatabaseNoVacia {
	
	@LocalServerPort
    private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void contextLoads() {
		ResponseEntity<User[]> response = restTemplate.getForEntity("http://localhost:" + port + "/users", User[].class);
	    User[] users = response.getBody();
		assertFalse(users.length > 0);
	}
}
