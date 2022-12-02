package com.proyecto.spring.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.spring.user.model.User;

public interface DAOUser extends JpaRepository<User, Long>{

}
