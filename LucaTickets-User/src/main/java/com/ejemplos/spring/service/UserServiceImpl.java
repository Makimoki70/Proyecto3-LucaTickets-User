package com.ejemplos.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplos.spring.model.User;
import com.ejemplos.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService  {
	
	@Autowired
	private UserRepository repo;

	@Override
	public List<User> findAll() {
		return repo.findAll();
	}

	@Override
	public Optional<User> findById(long id) {
		return repo.findById(id);
	}

	@Override
	public User save(User user) {
		return repo.save(user);
	}
	
	// EN SpringJPA no hay metodo Update
	@Override
	public Optional<User> update(User user) {
		return repo.update(user);
	}

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}

}
