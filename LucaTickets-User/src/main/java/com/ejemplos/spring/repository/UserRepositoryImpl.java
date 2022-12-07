package com.ejemplos.spring.repository;

import java.time.LocalDate;
import java.util.ArrayList;

//METODOS
/**
* findAll	Returns a Collection of all the students in the Map
* findById	Searches the Map for a student with the specified ID. If found, the student is returned.
* save	    Assigns the student an ID and saves the student in the Map.
* update	Replaces the student in the Map if it exists.
* delete	Deletes the student in the Map if it exists.
*/


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ejemplos.spring.model.User;


@Repository
public class UserRepositoryImpl implements UserRepository {

	private Map<Long, User> users = new HashMap<>();

	/*
	 * Typically, the database will assign the unique id (or primary key) when
	 * adding an entity. Since we are using an in-memory Map, we must explicitly
	 * assign the student id in the repository class. Allowing the client to assign
	 * the unique id is not RESTful.
	 */
	private long currentID = 100;
	
	// Ojo. Esto es solo para hacer una prueba
	public void datosPrueba() {
		users.put(++currentID, new User(currentID, "Antonio", "Santos", "master","8hd",LocalDate.now()));
		users.put(++currentID, new User(currentID, "Luis", "Sanz", "lechon","8hd",LocalDate.now()));
		users.put(++currentID, new User(currentID, "Maria", "Gómez", "junior","8hd",LocalDate.now()));
	}
	
	public UserRepositoryImpl() {
		super();
		// Ojo. esto solo para pruebas
		this.datosPrueba();
	}

	// Return all students
	@Override
	public List<User> findAll() {
		List<User> list = new ArrayList<>(users.values());
		return list;
	}
	
	
	// Find the student with this id
	/*
	 * We are using java.util.Optional as a container for our Student object as it
	 * will help us handle cases where Student is null. This is purely an
	 * implementation decision and has nothing to do with REST concepts or
	 * constraints.
	 */
	public Optional<User> findById(Long id) {
		User user = null;

		if (users.containsKey(id)) {
			user = users.get(id);
		}
		return Optional.ofNullable(user);
	}
	

	// Save a new student
	public User save(User user) {
		user.setId(++currentID);
		users.put(user.getId(), user);
		return user;
	}

	// Update the student with this id
	public Optional<User> update(User user) {
		User currentStudent = users.get(user.getId());

		if (currentStudent != null) {
			users.put(user.getId(), user);
			currentStudent = users.get(user.getId());
		}
		return Optional.ofNullable(currentStudent);
	}
	

	// Delete student with this id
	public void deleteById(Long id) {
		User currentStudent = users.get(id);
		System.out.println("------ "+currentStudent);

		if (currentStudent != null) {
			users.remove(id);
		};
		System.out.println("------ "+users);
	}


}
