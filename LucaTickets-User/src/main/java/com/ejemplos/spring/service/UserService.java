package com.ejemplos.spring.service;

import java.util.List;
import java.util.Optional;

import com.ejemplos.spring.model.User;

public interface UserService {
	
	// Return all students
	public List<User> findAll();
	
	// Find the student with this id
	public Optional<User> findById(long id);

	// Save a new student & update
	public User save(User user);
	// EN SpringJPA no hay metodo Update
	public Optional<User> update(User user);

	// Delete student with this id
	public void deleteById(Long id);


}
