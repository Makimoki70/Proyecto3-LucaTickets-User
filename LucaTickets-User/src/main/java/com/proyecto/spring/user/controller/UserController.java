package com.proyecto.spring.user.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.spring.user.model.User;
import com.proyecto.spring.user.model.adapter.UserDateAdapter;
import com.proyecto.spring.user.model.response.DTOUser;
import com.proyecto.spring.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDateAdapter adapter;
	
	@PostMapping("/add")
	public ResponseEntity<DTOUser> saveUser(@RequestBody DTOUser user) {
		User result = userService.addUser(adapter.convertToEntity(user));
		return ResponseEntity.of(Optional.of(adapter.convertToDto(result)));
	}
}
